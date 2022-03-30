package ShopAppJwt.service.JWT;

import ShopAppJwt.globalException.ExceptionType;
import ShopAppJwt.mapper.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseMapper JwtAuthService(String username, String password) {
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            return ResponseMapper.error(ExceptionType.USER_INPUT_ERROR, "Alreardy Logged In !");
        } //  use for spring security session

        UsernamePasswordAuthenticationToken userToken
                 = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(userToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResponseMapper.successData(jwtTokenUtil.generateToken(username));
    }

    @Override
    public ResponseMapper refreshToken(String oldToken) {
        if (!jwtTokenUtil.isTokenExpired(oldToken) || jwtTokenUtil.getUsernameFromToken(oldToken) != null) {
            return ResponseMapper.error(ExceptionType.USER_INPUT_ERROR, "Valid Error ， Please Try Again Later !");
        }
        return ResponseMapper.successData(jwtTokenUtil.refreshToken(oldToken));
    }
}
