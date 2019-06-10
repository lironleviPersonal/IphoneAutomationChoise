import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EMailUtility {

    private String myEmailAccount = "lironlevi91@gmail.com";
    private String myPasswordAccount = "8891LK91";
    private String header;
    private String price;

    Properties properties;
    Session session;


    public EMailUtility(String header, String price) {
        this.header = header;
        this.price = price;
        properties = new Properties();
        session = createMailInfrastracture();
    }

    public void sendMail() {
        try {
            Transport.send(createMessage(session));
            System.out.println("message send");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private Message createMessage(Session session) {
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


    private Session createMailInfrastracture() {
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

    public String getMail() {
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
