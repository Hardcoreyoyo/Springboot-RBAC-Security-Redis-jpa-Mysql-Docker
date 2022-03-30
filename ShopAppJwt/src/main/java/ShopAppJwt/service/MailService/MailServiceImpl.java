package ShopAppJwt.service.MailService;

import ShopAppJwt.dao.User.UserDao;
import ShopAppJwt.mapper.ResponseMapper;
import ShopAppJwt.model.Member.UserModel;
import ShopAppJwt.service.JWT.JwtTokenUtil;
import ShopAppJwt.service.Security.SecurityService;
import ShopAppJwt.service.UserService.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService{

    @Autowired
    UserDao userDao;

    @Autowired
    SecurityService securityService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender mailSender;


    @Override
    @Async("SendMailExecutor")
    public ResponseMapper MailHandler(String username, String email) throws MessagingException {
        String token = MailTokenUtil(username);
        SignUpBasicMailSend(username, email, token);
        return ResponseMapper.successStatus();
    }

    @Override
    @Async("SendMailExecutor")
    public ResponseMapper ResetMailHandler(String username, String email) throws MessagingException {
        String token = MailTokenUtil(username);
        ResetMailSend(username, email, token);
        return ResponseMapper.successStatus();
    }

    public void SignUpBasicMailSend(String username, String email, String token) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
        Context context = new Context();
        ClassPathResource classPathResource = new ClassPathResource("static/images/image1.png");

        String TokenMailAddress = "http://localhost:8080/email/confirm?token=" + token;
        context.setVariable("ValidateEmailAddress", TokenMailAddress);
        context.setVariable("username", username);
        String content = templateEngine.process("/Member/SignUpBasic", context);

        message.setFrom("adgdgasdg@gmail.com");
        message.setTo(email);
        message.setSubject("Sent Gmail Testing Email");
        message.setText(content, true);
        message.addAttachment("file1.jpeg",classPathResource);

        mailSender.send(mimeMessage);
    }

    public void ResetMailSend(String username, String email, String token) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
        Context context = new Context();

        String TokenMailAddress = "http://localhost:8080/user/reset/confirm?token=" + token;
        context.setVariable("ValidateEmailAddress", TokenMailAddress);
        context.setVariable("username", username);
        String content = templateEngine.process("/Member/ResetPassword", context);

        message.setFrom("adgdgasdg@gmail.com");
        message.setTo(email);
        message.setSubject("Sent Gmail Reset Password Email");
        message.setText(content, true);

        mailSender.send(mimeMessage);
    }

    @Override
    public boolean MailtokenValidate(String token) {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        UserModel userModel = securityService.findUserByUsername(username);
        Boolean expired = jwtTokenUtil.isTokenExpired(token);

        if(userModel == null || expired){
            return false;
        }
        return true;
    }

    @Override
    public String MailTokenUtil(String username) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", username);
        claims.put("created", new Date());
        Date expirationDate = new Date(System.currentTimeMillis() + jwtTokenUtil.getExpiration());
        return Jwts.builder().setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtTokenUtil.getSecret())
                .compact();
    }
}
