package ord.syscomputer.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ord.syscomputer.dao.ClientRepository;
import ord.syscomputer.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
	
@RestController
public class ClientRest {
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/clients")	
	public Page<Client> listClients( int page, int size){
		return clientRepository.findAll(new PageRequest(page, size));
	}
	
	@RequestMapping(value="/getUser")
	public  Map<String , Object> getLogedUser(HttpServletRequest httpServletRequest){
		
		//je recupere la session
		HttpSession httpSession=httpServletRequest.getSession();
		//je recupere l'objet securité context
		SecurityContext securityContext =(SecurityContext)
				httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
				String username=securityContext.getAuthentication().getName();
				List<String> roles=new ArrayList<>();
				for(GrantedAuthority ga:securityContext.getAuthentication().getAuthorities())
				{
					roles.add(ga.getAuthority());
				}
				Map<String,Object> params=new HashMap<>();
				params.put("username", username);
				params.put("roles", roles);
				
					return params;
		
	}
	
	
}
