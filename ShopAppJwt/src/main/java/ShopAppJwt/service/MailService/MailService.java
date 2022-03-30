package ShopAppJwt.service.MailService;

import ShopAppJwt.mapper.ResponseMapper;

import javax.mail.MessagingException;

public interface MailService {

    ResponseMapper MailHandler(String username, String email) throws Exception;

    ResponseMapper ResetMailHandler(String username, String email) throws MessagingException;

    void ResetMailSend(String username, String email, String token) throws Exception;

    void SignUpBasicMailSend(String username, String email, String token) throws Exception;

    boolean MailtokenValidate(String token);

    String MailTokenUtil(String username);
}
