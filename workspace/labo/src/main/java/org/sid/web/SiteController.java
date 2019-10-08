//package org.sid.web;
//
//import org.sid.dao.ArticleRepository;
//import org.sid.entities.Article;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class SiteController {
//
//	@Autowired
//	private siteRepository siteRepository;
//	
//	@RequestMapping(value="/site",method=RequestMethod.GET)
//	public String acceuil (Model model,
//			@RequestParam(name="mc",defaultValue="")String motCle,
//			@RequestParam(name="page",defaultValue="0")int page){
//		Page<Site> pageSite=siteRepository.chercherSite("%"+motCle+"%", 
//		new PageRequest(page, 4));
//		
//		model.addAttribute("pageSite", pageSite);
//		model.addAttribute("pageCourante", page);
//		model.addAttribute("mc", motCle);
//		int [] pages =new int [pageSite.getTotalPages()];
//		for (int i =0; i<pages.length;i++)
//		{
//			pages[i]=i;
//		}
//		model.addAttribute("pages", pages);
//		return "site";
//	
//}
