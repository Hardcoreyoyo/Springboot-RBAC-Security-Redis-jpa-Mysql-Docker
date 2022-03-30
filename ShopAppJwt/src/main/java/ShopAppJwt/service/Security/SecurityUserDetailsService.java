package ShopAppJwt.service.Security;

import ShopAppJwt.model.Member.SecurityUserDetails;
import ShopAppJwt.model.Member.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private SecurityService securityService;

    @Override
    public SecurityUserDetails loadUserByUsername(String username) {

        UserModel userModel = securityService.findUserByUsername(username);

        SecurityUserDetails securityUserDetails =  new SecurityUserDetails();
        securityUserDetails.setUsername(userModel.getUsername());
        securityUserDetails.setPassword(userModel.getPassword());
        securityUserDetails.setEnabled(userModel.isEnabled());

        List<String> roleCodes = securityService.findRoleMapUser(username);
        Set<String> authorities = new HashSet<>();

        for (String s:roleCodes) {
            authorities.addAll(securityService.findUrlMapRole(s));
        }

        roleCodes = roleCodes.stream()
                .map(rc -> "ROLE_" + rc )
                .collect(Collectors.toList());

        authorities.addAll(roleCodes);

        securityUserDetails.setAuthorities(
                AuthorityUtils.commaSeparatedStringToAuthorityList(
                        String.join(",",authorities)
                )
        );

        return securityUserDetails;
    }
}
