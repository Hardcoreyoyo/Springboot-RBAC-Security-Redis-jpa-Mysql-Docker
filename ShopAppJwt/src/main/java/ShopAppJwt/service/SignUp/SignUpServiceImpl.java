package ShopAppJwt.service.SignUp;

import ShopAppJwt.dao.Text.TextDao;
import ShopAppJwt.dao.User.UserDao;
import ShopAppJwt.globalException.ExceptionType;
import ShopAppJwt.mapper.ResponseMapper;
import ShopAppJwt.model.Member.RoleModel;
import ShopAppJwt.model.Member.UserModel;
import ShopAppJwt.model.Text.TextModel;
import ShopAppJwt.service.MailService.MailService;
import ShopAppJwt.service.Security.SecurityService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Data
@Service
@ConfigurationProperties(prefix = "signup")
public class SignUpServiceImpl implements SignUpService{

    private String admin;
    private String email;
    private Integer level;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TextDao textDao;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public ResponseMapper SignUpHandler(String username, String password, String userEmail) throws Exception {
        boolean save = SaveUsernamePassword(username, password, userEmail);
        if(save){
            mailService.MailHandler(username, userEmail);
            mailService.MailHandler(admin, email);
            return ResponseMapper.successStatus();
        }
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Registration Fail ， Please Try Again Later !");
    }

    @Override
    public boolean SaveUsernamePassword(String username, String password, String userEmail) {
        UserModel user = userDao.findByUsername(username);
        boolean email = userDao.existsByEmail(userEmail);
        if(user == null && !email) {
                UserModel userModel = new UserModel();
                userModel.setUsername(username);
                userModel.setPassword(passwordEncoder.encode(password));
                userModel.setEmail(userEmail);
                userModel.setEnabled(false);

                RoleModel roleModel = new RoleModel();
                roleModel.setRoleId(level);
                userModel.setUserRole(List.of(roleModel));

                TextModel textModel = new TextModel();
                textModel.setUsername(username);
                textModel.setText("You can Write Anything");

                userDao.save(userModel);
                textDao.save(textModel);
                return true;
        }
        return false;
    }

    @Transactional
    @Override
    public void OAuthSaveUsernamePassword(String username, String password) {
        boolean CheckOAuthUsername = userDao.existsByUsername(username);
        if(!CheckOAuthUsername){

            UserModel userModel = new UserModel();
            userModel.setUsername(username);
            userModel.setPassword(passwordEncoder.encode(password));
            userModel.setEnabled(true);

            RoleModel roleModel = new RoleModel();
            roleModel.setRoleId(level);
            userModel.setUserRole(List.of(roleModel));

            TextModel textModel = new TextModel();
            textModel.setUsername(username);
            textModel.setText("You can Write Anything");

            userDao.save(userModel);
            textDao.save(textModel);
        }
    }

}
