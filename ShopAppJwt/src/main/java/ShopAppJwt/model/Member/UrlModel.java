package ShopAppJwt.model.Member;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sys_url",
        indexes = {@Index(name = "indexUrl", columnList = "url")})
public class UrlModel implements Serializable {

    private static final long serialVersionUID = -7627260232608805579L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "url_id")
    private Integer urlId;

    @Column(name = "url", length = 255)
    private String url;

    @JsonIgnore
    @ManyToMany(targetEntity = RoleModel.class,
            cascade = {CascadeType.MERGE
                    , CascadeType.DETACH
                    , CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinTable(name = "sys_url_role",
            joinColumns = {
                    @JoinColumn(name = "from_url_id", referencedColumnName = "url_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "from_role_id", referencedColumnName = "role_id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"from_url_id", "from_role_id"})}
    )
    private List<RoleModel> urlRole;
}