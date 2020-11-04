/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import com.sun.mail.util.MailSSLSocketFactory;
import java.io.UnsupportedEncodingException;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author Klein
 */
public class email {

    public static String enviar(String assunto, String destinatario, String mensagem, String anexo, String user) throws UnsupportedEncodingException {

        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        sf.setTrustAllHosts(true);
        //propriedades
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.ssl.socketFactory", sf);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("gerformjava@gmail.com", "postgres");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(false);

        try {
            // cria a mensagem
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gerformjava@gmail.com", user));
            Address[] toUser = InternetAddress.parse(destinatario);
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);

            // cria a primeira parte da mensagem
            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setText(mensagem);

            // cria a segunda parte da mensage
            MimeBodyPart mbp2 = new MimeBodyPart();

            if (anexo != null) {
                // anexa o arquivo na mensagem
                FileDataSource fds = new FileDataSource(anexo);
                mbp2.setDataHandler(new DataHandler(fds));
                mbp2.setFileName(fds.getName());
            }

            // cria a Multipart
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);
            if (anexo != null) {
                mp.addBodyPart(mbp2);
            }

            // adiciona a Multipart na mensagem
            message.setContent(mp);

            // configura a data: cabecalho
            message.setSentDate(new Date());

            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);

        } catch (MessagingException e) {
            //throw new RuntimeException(e);
            return new RuntimeException(e).toString();
        }
        return "Mensagem enviada com sucesso!";
    }
}
