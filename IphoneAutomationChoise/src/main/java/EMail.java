import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EMail {

    private  String myEmailAccount = "lironlevi91@gmail.com";
    private  String myPasswordAccount = "8891LK91";

    private String subject;
    private String text;

    public EMail(String subject, String text){
        this.subject = subject;
        this.text = text;
    }

    public void sendMail(){
        try {
            Session session = createMailInfrastracture();
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
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(myEmailAccount));
            message.setSubject(subject);
            message.setText(text);
            return message;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Session  createMailInfrastracture(){
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");



            Session session = Session.getInstance(properties, new Authenticator() {


                @Override
                protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(myEmailAccount, myPasswordAccount);
                }
            });
            return session;

        }
    }
