package Search.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringExpressions;
import com.querydsl.core.types.dsl.StringPath;

import Search.entity.MyUser;
import Search.entity.QMyUser;

public interface MyUserRepository
extends JpaRepository<MyUser, Long>,
QueryDslPredicateExecutor<MyUser>,
QuerydslBinderCustomizer<QMyUser>{

	//long count(Predicate predicate);            
	
    //Iterable<MyUser> findAll(Predicate predicate);   

/*	@Override
    default public void customize(QuerydslBindings bindings, QMyUser user) {
     
      bindings.bind(String.class)
      .first((SingleValueBinding<StringPath, String>) 
      StringExpression::containsIgnoreCase); 
      bindings.excluding(user.email);                                           
    }*/
	
    Iterable<MyUser> findAll(Predicate predicate);  
    
	 @Override
	  default public void customize(QuerydslBindings bindings, QMyUser user) {

	    bindings.bind(user.firstName).first((path, value) -> path.contains(value)); 
	    bindings.bind(String.class)
	      .first((StringPath path, String value) -> path.containsIgnoreCase(value)); 
	    bindings.excluding(user.email);                                           
	  }

	
}
