package Search.entity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.querydsl.core.types.Predicate;
import Search.entity.MyUser;
import Search.entity.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	@ResponseBody
	public Iterable<MyUser> findAllByWebQuerydsl(
			@QuerydslPredicate(root = MyUser.class) Predicate predicate,
			@RequestParam MultiValueMap<String, String> parameters) {
		System.out.println(parameters.toString());
		return userRepository.findAll(predicate);
	}

}