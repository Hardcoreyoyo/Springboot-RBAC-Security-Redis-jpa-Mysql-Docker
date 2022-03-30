package ShopAppJwt.service.UserService;

import ShopAppJwt.mapper.ResponseMapper;

import javax.mail.MessagingException;

public interface UserService {

    ResponseMapper ChangePwd(String username, String OldPassword, String newPassword);

    ResponseMapper AdminChangeInfo(String username, String password, String email, Integer role);

    ResponseMapper DeleteUser(String username);

    ResponseMapper ResetPwdSend(String email) throws MessagingException;

    ResponseMapper EnableUser(String username);

    ResponseMapper PageQueryAll(int page, int size) throws NoSuchFieldException;

}
