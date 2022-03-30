package ShopAppJwt.UnitTest;

import ShopAppJwt.dao.Text.TextDao;
import ShopAppJwt.dao.User.UserDao;
import ShopAppJwt.model.Member.RoleModel;
import ShopAppJwt.model.Member.UserModel;
import ShopAppJwt.model.Text.TextModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TextDao textDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void Save(){
        UserModel userModel = new UserModel();
        userModel.setUsername("user2");
        userModel.setPassword(passwordEncoder.encode("12345"));
        userModel.setEmail("user2user2@user2.com");
        userModel.setEnabled(true);

        RoleModel roleModel = new RoleModel();
        roleModel.setRoleId(3);
        userModel.setUserRole(List.of(roleModel));

        TextModel textModel = new TextModel();
        textModel.setUsername("user2");
        textModel.setText("Testing Write Text");

        userDao.save(userModel);
        textDao.save(textModel);
    }

    @Test
    public void findByUsername(){
        UserModel userModel = userDao.findByUsername("user2");
        assertNotNull(userModel);
        assertEquals(54, userModel.getUserId());
        assertTrue(userModel.isEnabled());
    }

    @Test
    public void findByEmail(){
        UserModel userModel = userDao.findByEmail("user2user2@user2.com");
        assertNotNull(userModel);
        assertEquals(54, userModel.getUserId());
        assertTrue(userModel.isEnabled());
    }

    @Test
    public void existsByUsername(){
        boolean userModel = userDao.existsByUsername("user2");
        assertTrue(userModel);
    }

    @Test
    public void findRoleMapUser(){
        List<String> userModel = userDao.findRoleMapUser("user1");
        assertNotNull(userModel);
        assertEquals("USER", userModel.get(0));
    }

    @Test
    public void findUrlMapRole(){
        List<String> userModel = userDao.findUrlMapRole("USER");
        assertEquals("/user/change/pwd", userModel.get(0));
        assertNotNull(userModel);
    }
}
