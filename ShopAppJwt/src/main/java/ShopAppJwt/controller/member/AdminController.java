package ShopAppJwt.controller.member;

import ShopAppJwt.globalException.ExceptionType;
import ShopAppJwt.mapper.ResponseMapper;
import ShopAppJwt.mapper.UserInfoMapper;
import ShopAppJwt.service.Security.SecurityService;
import ShopAppJwt.service.SignUp.SignUpService;
import ShopAppJwt.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/query/all/{page}/{size}")
    public ResponseMapper PageQueryAll(@PathVariable int page,
                                       @PathVariable int size) throws NoSuchFieldException {
        return userService.PageQueryAll(page, size);
    }

    @GetMapping("/read/{name}")
    public ResponseMapper AdminQuery(@PathVariable String name){
        return ResponseMapper.successData(securityService.findUserByUsername(name));
    }

    @PostMapping("/create/{username}/{password}/{email}")
    public ResponseMapper AdminCreate(@PathVariable String username,
                                      @PathVariable String password,
                                      @PathVariable String email) throws Exception {
        return signUpService.SignUpHandler(username, password, email);
    }

    @PutMapping("/update/{username}")
    public ResponseMapper AdminPut(@PathVariable String username,
                                   @RequestBody @Valid UserInfoMapper acim) {
        if(acim.getEmail() == null && acim.getPassword() == null && acim.getRole() == null){
            return ResponseMapper.error(ExceptionType.USER_INPUT_ERROR,
                    "Missing Data ， Please Try Again !");
        }
        return userService.AdminChangeInfo(username,
                                           acim.getPassword(),
                                           acim.getEmail(),
                                           acim.getRole());
    }

    @DeleteMapping("/delete/{username}")
    public ResponseMapper AdminDelete(@PathVariable String username) {
        return userService.DeleteUser(username);
    }

}
