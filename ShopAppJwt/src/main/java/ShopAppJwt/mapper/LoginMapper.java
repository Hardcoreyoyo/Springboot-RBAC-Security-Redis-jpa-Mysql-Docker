package ShopAppJwt.mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginMapper {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
