package by.markov.services.mailsender;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class Sender {

    public void sendCheckToMail(String message) throws MessagingException, IOException {
        final Properties properties = new Properties();
        properties.load(Sender.class.getClassLoader().getResourceAsStream("mail.properties"));

        Session session = Session.getDefaultInstance(properties);
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("markovadim"));
        //change address to input mail (!)
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("markovadim@gmail.com"));
        mimeMessage.setSubject("Test Mail");
        mimeMessage.setText(message);

        Transport transport = session.getTransport();
        transport.connect("markovadim", "****");
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
    }
}
