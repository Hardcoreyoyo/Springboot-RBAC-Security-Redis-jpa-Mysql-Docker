package ShopAppJwt.service.JWT;

import ShopAppJwt.mapper.ResponseMapper;

public interface JwtService {

    ResponseMapper JwtAuthService(String username, String password);

    ResponseMapper refreshToken(String oldToken);

}
