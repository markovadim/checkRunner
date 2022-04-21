package by.markov.services.mailsender;

import by.markov.services.event.Observer;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class SenderImplObserver implements Observer {

    public void sendCheckToMail(String message) throws IOException {
        final Properties properties = new Properties();
        properties.load(SenderImplObserver.class.getClassLoader().getResourceAsStream("mail.properties"));
        Session session = Session.getDefaultInstance(properties);

        try (Transport transport = session.getTransport(); Scanner password = new Scanner(System.in)) {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress("user"));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("markovadim@gmail.com"));
            mimeMessage.setSubject("Check of Payment");
            mimeMessage.setText(message);
            System.out.println("Enter the password of user mail:");
            transport.connect(properties.getProperty("user"), password.nextLine());
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleEvent(String message) throws IOException {
        sendCheckToMail(message);
    }
}
