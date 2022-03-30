package ShopAppJwt.controller.member;

import ShopAppJwt.mapper.OAuthMapper.GithubOAuthMapper;
import ShopAppJwt.mapper.ResponseMapper;
import ShopAppJwt.service.OAuth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class OAuthController {

    @Autowired
    private GithubOAuthMapper gOAuth;

    @Autowired
    private OAuthService oAuthService;

    @RequestMapping("/oauth")
    public RedirectView GithubGetCode(){
        String url = "https://github.com/login/oauth/authorize?" +
                "client_id=" + gOAuth.getId() +
                "&redirect_uri=" + gOAuth.getUrl();
        return new RedirectView(url);
    }

    @RequestMapping("/callback")
    public ResponseMapper GithubCallBack(@RequestParam String code){
        return oAuthService.GithubOAuthJWTHandler(code);
    }

}
