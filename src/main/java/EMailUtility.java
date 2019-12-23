import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public final class EMailUtility {

    private static String myEmailAccount = "lironlevi91@gmail.com";
    private static String myPasswordAccount = "8891LK91";
    private static Properties properties;
    private static Session session;

    public static void sendMail(String header, String price) {
        try {
            properties = new Properties();
            session = createMailInfrastracture();
            Transport.send(createMessage(session, header, price));
            Logs.information("Email notification send to lironlevi91@gmail.com");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static Message createMessage(Session session, String header, String price) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmailAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(myEmailAccount));
            message.setSubject("Aut Test");
            message.setText("Name: " + header + " price: " + price);
            return message;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Session createMailInfrastracture() {
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmailAccount, myPasswordAccount);
            }
        });
        return session;
    }

    public static String getMail() {
       String msg = null;
        try {
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", myEmailAccount, myPasswordAccount);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message[] messages = inbox.getMessages();
            msg = messages[messages.length - 1].getSubject() + " " + messages[messages.length - 1].getContent();
        } catch (Exception mex) {
            mex.printStackTrace();
        }
        return msg;
    }
}
