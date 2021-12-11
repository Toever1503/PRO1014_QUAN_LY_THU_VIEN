/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import io.github.cdimascio.dotenv.Dotenv;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author haunv
 */
public class Networking {

    private static boolean mail_net(String mailAddress, String subject, String content) {
        Dotenv mailConfig = DOTENV.getEnv("config.env"); // get sqlConfig from .env file
        if (mailConfig == null) { // return null if config null
            return false;
        }

        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.host", mailConfig.get("MAILTRAP_HOST"));
        props.setProperty("mail.smtp.port", mailConfig.get("MAILTRAP_PORT"));
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailConfig.get("MAILTRAP_USERNAME"), mailConfig.get("MAILTRAP_PASSWORD"));
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        MimeMessage mine = new MimeMessage(session);
        try {
            mine.setFrom(new InternetAddress("QuanLyThuVien@gmail.com"));
            mine.setRecipient(Message.RecipientType.TO, new InternetAddress(mailAddress));
            mine.setSubject(subject);
            mine.setText(content);
            Transport.send(mine);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean sendMail(String mailAddress, String subject, String content) {
        return mail_net(mailAddress, subject, content);
    }

    public static void main(String[] args) {
        sendMail("haunv1503@gmail.com", "hello", "acc");
    }
}
