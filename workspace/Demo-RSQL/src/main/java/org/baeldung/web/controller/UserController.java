package org.baeldung.web.controller;
import java.util.List;

import org.baeldung.persistence.dao.rsql.CustomRsqlVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Search.specification.Entity.User;
import Search.specification.Repository.UserRepository;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    @ResponseBody
    public List<User> findAllByRsql() {
    	 Node rootNode = new RSQLParser().parse("firstName=in=(john,jack)");
         Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<User>());
         List<User> results = userRepository.findAll(spec);
		return results;
 }

    
}
