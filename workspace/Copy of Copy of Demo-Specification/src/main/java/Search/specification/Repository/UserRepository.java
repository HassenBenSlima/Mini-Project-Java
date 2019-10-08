package Search.specification.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import Search.specification.Entity.User;

public interface UserRepository extends 
JpaRepository <User,Long>,JpaSpecificationExecutor<User>{

}
