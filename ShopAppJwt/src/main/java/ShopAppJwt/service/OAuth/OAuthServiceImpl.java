package ShopAppJwt.service.OAuth;

import ShopAppJwt.mapper.OAuthMapper.GithubAccessTokenMapper;
import ShopAppJwt.mapper.OAuthMapper.GithubOAuthMapper;
import ShopAppJwt.mapper.OAuthMapper.GithubUserMapper;
import ShopAppJwt.mapper.ResponseMapper;
import ShopAppJwt.service.JWT.JwtTokenUtil;
import ShopAppJwt.service.SignUp.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class OAuthServiceImpl implements OAuthService{

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private GithubOAuthMapper gOAuth;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public ResponseMapper GithubOAuthJWTHandler(String code) {
        String AccessToken = getGithubAccessToken(code);

        ResponseEntity<GithubUserMapper> UserInfo
                = getGithubUserInfo(AccessToken);

        String username = Objects.requireNonNull(UserInfo.getBody()).getLogin();
        String password = Integer.toString(UserInfo.getBody().getId());
        signUpService.OAuthSaveUsernamePassword(username, password);

        return ResponseMapper.successData(jwtTokenUtil.generateToken(username));
    }

    private String getGithubAccessToken(String code) {
        // 可以考慮使用 com.github.scribejava 包簡化代碼
        HttpHeaders httpHeadersCode = new HttpHeaders();
        httpHeadersCode.add("Accept"
                , "application/json");

        String accessTokenUrl =
                "https://github.com/login/oauth/access_token?" +
                        "client_id=" + gOAuth.getId() +
                        "&client_secret=" + gOAuth.getSecret() +
                        "&code=" + code;

        HttpEntity<String> entityCode = new HttpEntity<>(httpHeadersCode);
        ResponseEntity<GithubAccessTokenMapper> responseCode =
                restTemplate.exchange(
                        accessTokenUrl,
                        HttpMethod.POST,
                        entityCode,
                        GithubAccessTokenMapper.class);

        return Objects.requireNonNull(responseCode.getBody()).getAccess_token();
    }

    private ResponseEntity<GithubUserMapper> getGithubUserInfo(String token){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization"
                , "token " + token);
        httpHeaders.add("Accept",
                "application/vnd.github.v3+json");

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(
                "https://api.github.com/user",
                HttpMethod.GET,
                entity,
                GithubUserMapper.class);
    }
}
