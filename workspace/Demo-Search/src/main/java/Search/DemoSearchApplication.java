package Search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Search.entity.MyUser;
import Search.entity.repository.MyUserRepository;

@SpringBootApplication
public class DemoSearchApplication implements CommandLineRunner{
	
	@Autowired
	private  MyUserRepository myUserRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSearchApplication.class, args);
}

	@Override
	public void run(String... args) throws Exception {
/*myUserRepository.save(new MyUser("Jonn", "Doe", "John@doe.com",22));		
myUserRepository.save(new MyUser("hassen", "ben Slima", "hassen@email.com",25));
myUserRepository.save(
new MyUser("Tom", "Doe", "tom@doe.com",26));
*/
//myUserRepository.findAll().forEach(x->System.out.println(x));
	
	}
}
