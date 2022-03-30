package ShopAppJwt.service.SignUp;

import ShopAppJwt.mapper.ResponseMapper;

public interface SignUpService {

    ResponseMapper SignUpHandler(String username, String password, String email) throws Exception;

    boolean SaveUsernamePassword(String username, String password, String email);

    void OAuthSaveUsernamePassword(String username, String password);
}

