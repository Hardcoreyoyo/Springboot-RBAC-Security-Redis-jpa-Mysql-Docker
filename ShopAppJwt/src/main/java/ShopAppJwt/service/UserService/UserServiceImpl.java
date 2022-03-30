package ShopAppJwt.service.UserService;

import ShopAppJwt.dao.User.UserDao;
import ShopAppJwt.globalException.ExceptionType;
import ShopAppJwt.mapper.ResponseMapper;
import ShopAppJwt.model.Member.RoleModel;
import ShopAppJwt.model.Member.UserModel;
import ShopAppJwt.service.MailService.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.mail.MessagingException;
import java.util.LinkedList;
import java.util.List;

import static ShopAppJwt.config.CacheConfig.CacheKey.USER_DETAIL;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MailService mailService;

    @Override
    public ResponseMapper ResetPwdSend(String email) throws MessagingException {
        UserModel userModel = userDao.findByEmail(email);
        if (userModel != null){
            mailService.ResetMailHandler(
                    userModel.getUsername(),
                    userModel.getEmail());
            return ResponseMapper.successStatus();
        }
        return ResponseMapper.error(ExceptionType.USER_INPUT_ERROR,
                "Valid Error ， Please Try Again !");
    }

    @Override
    @Transactional
    @CacheEvict(value = USER_DETAIL, key = "#username")
    public ResponseMapper ChangePwd(String username, String OldPassword, String newPassword) {
        UserModel userModel = userDao.findByUsername(username);
        boolean result = passwordEncoder.matches(OldPassword, userModel.getPassword());
        if(userModel != null && result){
            userModel.setPassword(passwordEncoder.encode(newPassword));
            userDao.save(userModel);
            return ResponseMapper.successStatus();
        }
        return ResponseMapper.error(ExceptionType.USER_INPUT_ERROR,
                "Valid Error ， Please Try Again !");
    }

    @Override
    @Transactional
    @CacheEvict(value = USER_DETAIL, key = "#username")
    public ResponseMapper AdminChangeInfo(String username,
                                          String password,
                                          String email,
                                          Integer role) {
        UserModel userModel = userDao.findByUsername(username);
        if(userModel != null){

            if(password != null){
                userModel.setPassword(passwordEncoder.encode(password));
            }
            if(email != null){
                userModel.setEmail(email);
            }
            if(role != null){
                RoleModel roleModel = new RoleModel();
                roleModel.setRoleId(role);
                userModel.setUserRole(List.of(roleModel));
            }
            userDao.save(userModel);
            return ResponseMapper.successStatus();
        }
        return ResponseMapper.error(ExceptionType.USER_INPUT_ERROR,
                "Valid Error ， Please Try Again !");
    }

    @Override
    @Transactional
    @CacheEvict(value = USER_DETAIL, key = "#username")
    public ResponseMapper DeleteUser(String username) {
        UserModel userModel = userDao.findByUsername(username);
        if(userModel != null){
            userDao.delete(userModel);
            return ResponseMapper.successStatus();
        }
        return ResponseMapper.error(ExceptionType.USER_INPUT_ERROR,
                "Valid Error ， Please Try Again !");
    }

    @Override
    @Transactional
    @CacheEvict(value = USER_DETAIL, key = "#username")
    public ResponseMapper EnableUser(String username) {
        UserModel userModel = userDao.findByUsername(username);
        if (userModel != null){
            userModel.setEnabled(true);
            userDao.save(userModel);
            return ResponseMapper.successStatus();
        }
        return ResponseMapper.error(ExceptionType.USER_INPUT_ERROR,
                "Valid Error ， Please Try Again !");
    }

    @Override // TODO: imporve to SliceImpl or use Elasticsearch further
    public ResponseMapper PageQueryAll(int page, int size) {

        Sort sort = Sort.by(Sort.Direction.ASC, "userId");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<UserModel> pageResult = userDao.findAll(pageable);

        List<Object> messageList = new LinkedList<>();
        messageList.add("本頁筆數: " + pageResult.getNumberOfElements());
        messageList.add("每頁筆數: " + pageResult.getSize());
        messageList.add("全部筆數: " + pageResult.getTotalElements());
        messageList.add("全部頁數: " + pageResult.getTotalPages());
        messageList.add(pageResult.getContent());

        return ResponseMapper.successData(messageList);
    }
}
