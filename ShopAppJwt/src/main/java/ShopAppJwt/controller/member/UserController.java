package ShopAppJwt.controller.member;

import ShopAppJwt.globalException.ExceptionType;
import ShopAppJwt.mapper.*;
import ShopAppJwt.service.JWT.JwtService;
import ShopAppJwt.service.JWT.JwtTokenUtil;
import ShopAppJwt.service.MailService.MailService;
import ShopAppJwt.service.SignUp.SignUpService;
import ShopAppJwt.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Validated
@RestController
public class UserController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/auth")
    public ResponseMapper LoginGet(){
        return ResponseMapper.successStatus();
    }

    @PostMapping("/auth")
    public ResponseMapper LoginPost(@RequestBody @Valid LoginMapper loginMapper){
        String username = loginMapper.getUsername();
        String password = loginMapper.getPassword();
        return jwtService.JwtAuthService(username, password);
    }

    @PostMapping("/refresh")
    public ResponseMapper refresh(@RequestHeader("${jwt.header}") @NotBlank String token) {
        return jwtService.refreshToken(token);
    }

    @GetMapping("/member")
    public ResponseMapper MemberCenter(){
        return ResponseMapper.successStatus();
    }

    @GetMapping("/admin")
    public ResponseMapper Admin(){
        return ResponseMapper.successStatus();
    }

    @GetMapping("/signup")
    public ResponseMapper SignUpGet(){
        return ResponseMapper.successStatus();
    }

    @PostMapping("/signup")
    public ResponseMapper SignUpPost(@RequestBody @Valid SignUpMapper signUpMapper) throws Exception {
        String username = signUpMapper.getUsername();
        String password = signUpMapper.getPassword();
        String email = signUpMapper.getEmail();
        return signUpService.SignUpHandler(username, password, email);
    }

    @GetMapping("/email/confirm")
    public ResponseMapper MailToken(@RequestParam("token") String token){
        if(mailService.MailtokenValidate(token)){
            String username = jwtTokenUtil.getUsernameFromToken(token);
            return userService.EnableUser(username);
        }
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Token Valid Error ， Please Try Again !");
    }

    @GetMapping("/user/change/pwd")
    public ResponseMapper ChengePwd(){
        return ResponseMapper.successStatus();
    }

    @PostMapping("/user/change/pwd")
    public ResponseMapper ChengePwd(@RequestBody @Valid ChangePwdMapper cpm){
        String username = GetAuthenticationUsername();
        String OldPassword = cpm.getOldPwd();
        String newPassword = cpm.getNewPwd();
        if (username != null && !Objects.equals(OldPassword, newPassword)) {
            return userService.ChangePwd(username, OldPassword, newPassword);
        }
        // put expiration jwt token to user and made him logged out (Negative acts)
        return ResponseMapper.error(ExceptionType.USER_INPUT_ERROR
                , "Valid Error ， Please Try Again !");
    }

    @GetMapping("/user/reset/send")
    public ResponseMapper ResetPwdSendGet() {
        return ResponseMapper.successStatus();
    }

    @PostMapping("/user/reset/send")
    public ResponseMapper ResetPwdSendPost(@RequestBody @Valid EmailMapper emailMapper) throws MessagingException {
        return userService.ResetPwdSend(emailMapper.getEmail());
    }

    @GetMapping("/user/reset/confirm")
    public ResponseMapper ResetPwdConfirmGet(@RequestParam("token") @NotNull String token) {
        if(mailService.MailtokenValidate(token)){
            return ResponseMapper.successStatus();
        }
        return ResponseMapper.error(ExceptionType.USER_INPUT_ERROR, "Valid Error ， Please Try Again !");
    }

    @PostMapping("/user/reset/confirm")
    public ResponseMapper ResetPwdConfirmPost(@RequestParam("token") @NotNull String token,
                                              @RequestBody @Valid ChangePwdMapper cpm) {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        String OldPassword = cpm.getOldPwd();
        String newPassword = cpm.getNewPwd();
        if(username != null && !Objects.equals(OldPassword, newPassword)){
            return userService.ChangePwd(username, OldPassword, newPassword);
        }
        return ResponseMapper.error(ExceptionType.USER_INPUT_ERROR, "Valid Error ， Please Try Again !");
    }

    private String GetAuthenticationUsername(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        }
        return null;
    }

}
