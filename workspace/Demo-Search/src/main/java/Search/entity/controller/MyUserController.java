package Search.entity.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

import Search.entity.MyUser;
import Search.entity.QMyUser;
import Search.entity.repository.MyUserRepository;

@RestController
public class MyUserController {
	@Autowired
	private MyUserRepository userRepository;

	@PersistenceContext
	private EntityManager em;

	@GetMapping("/doudou")
	public Iterable<MyUser> getAllUser(@RequestParam(name="x",required=false )String x) {
		QMyUser user = QMyUser.myUser;
		BooleanBuilder where=new BooleanBuilder();
		if(x!=null){
			where.and(user.firstName.equalsIgnoreCase(x)).and(
					user.lastName.startsWithIgnoreCase("ben slima"));
		}else{
			where.and(user.lastName.startsWithIgnoreCase("ben slima"));
		}
//		Predicate predicate = user.firstName.equalsIgnoreCase(x)
//				.and(user.lastName.startsWithIgnoreCase("ben slima"));
		return userRepository.findAll(where);
	}

	@GetMapping("/hassen")
	public List<Tuple> findAllUsers() {
		QMyUser user = QMyUser.myUser;
		JPAQuery<MyUser> query = new JPAQuery<MyUser>(em);
		//em.createQuery(deleteQuery)
		return query.select(user.lastName, user.firstName).from(user).fetch();

	}

}
