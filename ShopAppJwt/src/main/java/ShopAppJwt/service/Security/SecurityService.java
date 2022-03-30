package ShopAppJwt.service.Security;

import ShopAppJwt.model.Member.UserModel;
import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SecurityService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);

    UserModel findUserByUsername(String username);

    List<String> findRoleMapUser(String username);

    List<String> findUrlMapRole(String roleCode);
}
