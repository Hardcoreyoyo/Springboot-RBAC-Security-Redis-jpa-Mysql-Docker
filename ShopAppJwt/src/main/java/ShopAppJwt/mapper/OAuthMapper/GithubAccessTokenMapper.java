package ShopAppJwt.mapper.OAuthMapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubAccessTokenMapper {
    private String access_token;
    private String scope;
    private String token_type;
}
