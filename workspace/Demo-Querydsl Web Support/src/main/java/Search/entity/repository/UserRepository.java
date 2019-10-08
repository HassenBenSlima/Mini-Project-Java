package Search.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.dsl.StringPath;

import Search.entity.MyUser;
import Search.entity.QMyUser;
@RepositoryRestResource
public interface UserRepository 
	extends JpaRepository<MyUser, Long>,
	QueryDslPredicateExecutor<MyUser>,
	QuerydslBinderCustomizer<QMyUser>{

 
		 @Override
		  default public void customize(QuerydslBindings bindings, QMyUser user) {

		    bindings.bind(user.firstName).first((path, value) -> path.contains(value)); 
		    bindings.bind(String.class).
		    first((StringPath path, String value) -> path.containsIgnoreCase(value)); 
		    bindings.excluding(user.email);                                           
		  }

	}