package org.sid.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AcceuilController {
	
	@RequestMapping(value="/home")
	public String formHome(Model model){

		return "home";
	}
	
	@RequestMapping(value="/login")
	public String formLogin(Model model){

		return "Login";
	}

}
