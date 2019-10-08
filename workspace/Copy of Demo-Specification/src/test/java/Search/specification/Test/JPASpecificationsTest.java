package Search.specification.Test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Search.specification.Entity.User;
import Search.specification.Repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class JPASpecificationsTest {
	@Autowired
	private UserRepository repository;
	
	private User userJohn;
	private User userTom;
	
	@Before
	public void init(){
		userJohn=new User();
		userJohn.setFirstName("John");
		userJohn.setLastName("Doe");
		userJohn.setAge(22);
		repository.save(userJohn);
		
		userTom=new User();
	
		userTom.setFirstName("Tom");
		userTom.setLastName("Doe");
		userTom.setAge(26);
		repository.save(userTom);
	
	
	}
	
	
	
}
