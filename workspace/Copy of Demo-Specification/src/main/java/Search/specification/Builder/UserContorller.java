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
import com.google.common.base.Joiner;
import Search.specification.Entity.User;
import Search.specification.Repository.*;
import Search.specification.web.SearchOperation;

@Controller
public class UserContorller {

	@Autowired
	private UserRepository repo;
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	@ResponseBody
	public List<User> search(@RequestParam(value="search") String search){
	       UserSpecificationsBuilder builder = new UserSpecificationsBuilder();
	        String operationSetExper = Joiner.on("|")
	            .join(SearchOperation.SIMPLE_OPERATION_SET);
	        Pattern pattern = Pattern.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
	        Matcher matcher = pattern.matcher(search + ",");
	        while (matcher.find()) {
	            builder.with(matcher.group(1),
	            			matcher.group(2), 
	            			matcher.group(4),
	            			matcher.group(3), 
	            			matcher.group(5));
	        }

	        Specification<User> spec = builder.build();
	  
		return repo.findAll(spec);
		
	}


}
