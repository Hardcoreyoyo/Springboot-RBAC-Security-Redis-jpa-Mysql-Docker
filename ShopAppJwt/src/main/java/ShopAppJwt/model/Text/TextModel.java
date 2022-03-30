package ShopAppJwt.model.Text;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "sys_text")
public class TextModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "username", length = 255)
    private String username;

    @Column(name = "text", length = 255)
    private String text;

}