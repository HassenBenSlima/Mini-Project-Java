package Search.entity.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.querydsl.core.types.dsl.BooleanExpression;

import Search.entity.MyUser;
import Search.entity.MyUserPredicatesBuilder;
import Search.entity.repository.MyUserRepository;

@Controller
public class UserController {
	@Autowired
	private MyUserRepository myUserRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/myusers")
    @ResponseBody
    public Iterable<MyUser> findAllByQuerydsl(@RequestParam(value = "search") String search) {
        MyUserPredicatesBuilder builder = new MyUserPredicatesBuilder();
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
            }
        }
        BooleanExpression exp = builder.build();
        return myUserRepository.findAll(exp);
    }

}