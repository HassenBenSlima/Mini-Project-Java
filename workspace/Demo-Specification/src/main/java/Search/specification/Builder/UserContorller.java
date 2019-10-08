package Search.specification.Builder;

import static org.mockito.Matchers.matches;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

import Search.specification.Entity.User;
import Search.specification.Repository.UserRepository;

@Controller
public class UserContorller {

	@Autowired
	private UserRepository repo;
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	@ResponseBody
	public List<User> search(@RequestParam(value="search") String search){
		UserSpecificationBuilder builder= new UserSpecificationBuilder();
		Pattern pattern =Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
		Matcher matcher=pattern.matcher(search+",");
		while(matcher.find()){
		builder.with(matcher.group(1), 
				matcher.group(2), matcher.group(3))	;
		}
		Specification<User> spec=builder.build();
		
		
		return repo.findAll(spec);
		
	}


}
