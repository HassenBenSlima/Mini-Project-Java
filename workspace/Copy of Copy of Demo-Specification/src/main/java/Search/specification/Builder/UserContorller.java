package Search.specification.Builder;

import static org.mockito.Matchers.matches;

import java.util.List;
import java.util.Set;
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
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import cz.jirutka.rsql.parser.ast.Node;
import cz.jirutka.rsql.parser.ast.RSQLOperators;
@Controller
public class UserContorller {

	@Autowired
	private UserRepository repo;
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	@ResponseBody
	public List<User> search(@RequestParam(value="search") String search){
   	 Node rootNode = new RSQLParser().parse("search");
     Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<User>());
		return repo.findAll(spec);
		
	}


}
