package ShopAppJwt.model.Member;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "sys_role",
        indexes = {@Index(name = "indexRole", columnList = "role")})
@NoArgsConstructor
public class RoleModel implements Serializable {

    private static final long serialVersionUID = -3386383364906650513L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role", length = 255)
    private String role;

    @JsonIgnore
    @ManyToMany(mappedBy = "userRole")
    private List<UserModel> roleUser;

    @JsonIgnore
    @ManyToMany(mappedBy = "urlRole")
    private List<UrlModel> roleUrl;
}





