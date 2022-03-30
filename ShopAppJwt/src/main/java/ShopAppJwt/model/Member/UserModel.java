package ShopAppJwt.model.Member;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sys_user",
        indexes = {@Index(name = "indexUsername", columnList = "username")})
public class UserModel implements Serializable {

    private static final long serialVersionUID = -1673266643271547807L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username", length = 255)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "enabled")
    private boolean enabled;

    @CreatedDate
    @Column(name="create_time",
            insertable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;

    @LastModifiedDate
    @Column(name="edit_time",
            insertable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
    private Date editTime;

    @JsonIgnore
    @ManyToMany(targetEntity = RoleModel.class,
            cascade = {CascadeType.MERGE
                    , CascadeType.DETACH
                    , CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinTable(name = "sys_user_role",
            joinColumns = {
                    @JoinColumn(name = "from_user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "from_role_id", referencedColumnName = "role_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"from_user_id", "from_role_id"})}
    )
    private List<RoleModel> userRole;

}





