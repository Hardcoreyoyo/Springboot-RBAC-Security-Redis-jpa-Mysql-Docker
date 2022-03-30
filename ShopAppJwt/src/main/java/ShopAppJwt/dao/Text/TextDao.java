package ShopAppJwt.dao.Text;

import ShopAppJwt.model.Text.TextModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextDao extends JpaRepository<TextModel, Integer> {

}
