package ShopAppJwt.service.OAuth;

import ShopAppJwt.mapper.ResponseMapper;

public interface OAuthService {
    ResponseMapper GithubOAuthJWTHandler(String code);
}
