package ShopAppJwt.dao.User;

import ShopAppJwt.model.Member.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UserDao extends JpaRepository<UserModel, Integer> {

	UserModel findByUsername(String username);

	UserModel findByEmail(String email);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

	@Query(value =
			"SELECT role \n" +
			"FROM sys_role r \n" +
			"LEFT JOIN sys_user_role ur ON r.role_id = ur.from_role_id \n" +
			"LEFT JOIN sys_user u ON u.user_id = ur.from_user_id\n" +
			"WHERE u.username = :user"
			, nativeQuery = true)
	List<String> findRoleMapUser(@Param("user") String user);

	@Query(value =
			"SELECT url \n" +
			"FROM sys_url r \n" +
			"LEFT JOIN sys_url_role ur ON r.url_id = ur.from_url_id \n" +
			"LEFT JOIN sys_role u ON u.role_id = ur.from_role_id\n" +
			"WHERE u.role = :role"
			, nativeQuery = true)
	List<String> findUrlMapRole(@Param("role") String role);

}