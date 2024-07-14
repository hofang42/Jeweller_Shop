/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import javax.mail.PasswordAuthentication;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.UUID;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
/**
 *
 * @author tuank
 */
public class resetService {
    private final int LIMIT_MIMUS = 10; 
    private final String from = "tuankhai2608@gmail.com";
    private final String password = "bmod omof rbkz vjuc";
//    private static final SecureRandom secureRandom = new SecureRandom();
//    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();
//
//    public String generateToken() {
//        byte[] randomBytes = new byte[24];
//        secureRandom.nextBytes(randomBytes);
//        return base64Encoder.encodeToString(randomBytes);
//    }
//
//    public LocalDateTime expiredDateTime() {
//        return LocalDateTime.now().plus(1, ChronoUnit.HOURS);
//    }
//    
    public String generateToken()
    {
        return UUID.randomUUID().toString();
    }
    
//    public LocalDateTime expiredDateTime()
//    {
//        return LocalDateTime.now().plusMinutes(LIMIT_MIMUS);
//    }
    
    public Timestamp expiredDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(LIMIT_MIMUS);
        return Timestamp.valueOf(localDateTime);
    }
    public boolean isExpireTime(Timestamp time) {
    return time.before(Timestamp.valueOf(LocalDateTime.now()));
}
    
    public boolean sendEmail(String to, String link, String name)
    {
        Properties p = new Properties();
        p.put("mail.smtp.host","smtp.gmail.com");
        p.put("mail.smtp.port","587");
        p.put("mail.smtp.auth","true");
        p.put("mail.smtp.starttls.enable","true");
        
         Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        Session session = Session.getInstance(p,auth);
        MimeMessage msg = new MimeMessage(session);
        try{
            msg.addHeader("Content_Type", "text/html; charset=UTF-8");
            msg.setFrom(from);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
            msg.setSubject("Reset Password","UTF-8");
            String content = "<h1>Quen mat khau an loz a thang loz " + name + "</h1>" + "<p>Click the link to reset password"
                    + "<a href =" + link + ">Click here </a></p>";
            msg.setContent(content, "text/html; charset=UTF-8");
            Transport.send(msg);
            System.out.println("Send successfully");
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Send error");
            System.out.println(e);
            return false;
        }
        
                
    }
    
    
}
