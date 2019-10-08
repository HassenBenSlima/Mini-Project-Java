package ord.syscomputer.dao;

import ord.syscomputer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
	extends JpaRepository<User,String>{

	
}
