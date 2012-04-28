/**
 * Email services: for registration and user request password
 * Author: John
 * Date: 4.28.2012
 */
package util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import models.User;

import com.sun.mail.smtp.SMTPSSLTransport;

public class SendEmails {

	String host = "smtp.gmail.com";
	String from = "webcalendarservice@gmail.com";
    String userid = "webcalendarservice";
    String pass = "notmypassword";
    Properties props = System.getProperties();
    
    public SendEmails() {
    	props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", userid);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
    }
    
    public void welcome(User user) {

        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);
        try {
        	message.setFrom(new InternetAddress(from));
        	InternetAddress toAddress = new InternetAddress(user.getEmail());
            message.addRecipient(Message.RecipientType.TO, toAddress);
            
            message.setSubject("Welcome");
            message.setText("Welcome " + user.getFirstName() + ":\n\n" +
            				"Here is your user name: " + user.getUserName() + "\n\n" +
            				"TSP Team 1");
            
            Transport transport = session.getTransport("smtp");
            transport.connect(host, userid, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException e) {
        	e.printStackTrace();
        }
    } 
    
    public void sendPassword(User user) {

        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);
        try {
        	message.setFrom(new InternetAddress(from));
        	InternetAddress toAddress = new InternetAddress(user.getEmail());
            message.addRecipient(Message.RecipientType.TO, toAddress);
            
            message.setSubject("Password Request");
            message.setText("Hi " + user.getFirstName() + ":\n\n" +
            				"Here is your password: " + user.getPassword() + "\n\n" +
            				"TSP Team 1");
            
            Transport transport = session.getTransport("smtp");
            transport.connect(host, userid, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException e) {
        	e.printStackTrace();
        }
    }
}