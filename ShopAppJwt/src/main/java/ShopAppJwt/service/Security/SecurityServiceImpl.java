package ShopAppJwt.service.Security;

import ShopAppJwt.dao.User.UserDao;
import ShopAppJwt.model.Member.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ShopAppJwt.config.CacheConfig.CacheKey.*;

@Service("UrlAccessService")
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PathMatcher pathMatcher;

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        String getRequestUrl = request.getRequestURI();
        if(principal instanceof UserDetails){
            UserDetails userDetails = ((UserDetails)principal);

            for (GrantedAuthority grantedAuthority:userDetails.getAuthorities()) {
                boolean CheckUrl = pathMatcher.match(grantedAuthority.getAuthority(), getRequestUrl);
                if(CheckUrl){return true;}
            }
        }
        return false;
    }

//    @Cacheable(value = USER_DETAIL,key = "#username", sync = true)
    @Cacheable(value = USER_DETAIL, key = "#username")
    @Override
    public UserModel findUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Cacheable(value = ROLE_CODES, key = "#username")
    @Override
    public List<String> findRoleMapUser(String username) {
        return userDao.findRoleMapUser(username);
    }

    @Cacheable(value = API_URLS, key = "#roleCode")
    @Override
    public List<String> findUrlMapRole(String roleCode) {
        return userDao.findUrlMapRole(roleCode);
    }

}
