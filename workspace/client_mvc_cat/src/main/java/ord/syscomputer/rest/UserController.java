package ord.syscomputer.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.querydsl.core.BooleanBuilder;
//import org.apache.commons.lang3.StringUtils;
import com.querydsl.core.types.Predicate;
//import com.querydsl.core.types.dsl.StringPath;
import java.util.regex.Pattern;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ord.syscomputer.Factory.ProduitFactory;
import ord.syscomputer.dao.ProduitRepository;
import ord.syscomputer.dto.ProduitDTO;
import ord.syscomputer.entities.Produit;
import ord.syscomputer.entities.QProduit;
import springfox.documentation.annotations.ApiIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private ProduitRepository produitRepository;
	private final Logger log = LoggerFactory.getLogger(UserController.class);


	@ApiOperation(value = "Search a product")
	@RequestMapping(method = RequestMethod.GET, value = "/prods")
	@ResponseBody
	public Iterable<ProduitDTO> findAllByWebQuerydsl(
			@ApiIgnore @QuerydslPredicate(root = Produit.class) Predicate predicate,
			@RequestParam(name = "designation", required = false) String designation,
			@ApiParam(allowableValues = "900,905", required = true) @RequestParam(name = "prix", required = false) String p) {

		Iterable<Produit> prods = produitRepository.findAll(predicate);
		Iterable<ProduitDTO> prodDto = ProduitFactory.produitsToproduitsDtosIterable(prods);
		return prodDto;
	}

	@GetMapping("/test1")
	public Iterable<Produit> getAllUser(@RequestParam(name = "x", required = false) String x,
			@RequestParam(name = "des", required = false) String des) {
		QProduit produit = QProduit.produit;
		Predicate predicate = null;
		
		  try {
			if(x.equals("#q")){
			  
			  log.info("bien travaillé");
			  predicate =
			  produit.prix.loe(produit.quantite); return
			  produitRepository.findAll(predicate); }
		  } catch (Exception e) {
				log.info("Error");
			}
		  
		  try {
			if (des.startsWith("#")) {
				predicate = produit.designation.containsIgnoreCase(des.substring(1));
				return produitRepository.findAll(predicate);

			}
		} catch (Exception e) {
			log.info("Error");
		}

		return null;

	}

	@GetMapping("/test")
	public Iterable<Produit> getp(@RequestParam(name = "splits", required = false) String bothSplit) {
		QProduit produit = QProduit.produit;

		Predicate predicate = null;

		try {
			Pattern SPACE1 = Pattern.compile(" OR ");
			String[] arr1 = SPACE1.split(bothSplit);
			String arr_one1 = arr1[0];
			String arr_second2 = arr1[1];
			
			log.info(arr_one1 + " -|- " + arr_second2);

			predicate =  produit.designation.containsIgnoreCase(arr_one1)
			  .or(produit.designation.containsIgnoreCase(arr_second2)); 
			  return produitRepository.findAll(predicate);
				 
				  
			  
		} catch (Exception e) {
			//e.printStackTrace();
			log.info("there is a problem"+e.getMessage());

		}

		try {
			
			if (bothSplit.indexOf(' ') >= 1) {

				Pattern SPACE = Pattern.compile(" ");
				String[] arr = SPACE.split(bothSplit);
				String arr_one = arr[0];
				String arr_second = arr[1];

				log.info(arr_one + "/" + arr_second);

				if (arr_second.startsWith("-")) {

					log.info(arr_one + "/" + arr_second + "/" + bothSplit.indexOf(' '));
					log.info(arr_second.substring(1));
					predicate = produit.designation.containsIgnoreCase(arr_one)
							.and(produit.designation.containsIgnoreCase(arr_second.substring(1)).not());
					return produitRepository.findAll(predicate);

				} else {
					log.info(arr_one + "/" + arr_second + "/" + bothSplit.indexOf(' '));

					predicate = produit.designation.containsIgnoreCase(arr_one)
							.and(produit.designation.containsIgnoreCase(arr_second));
					return produitRepository.findAll(predicate);

				}
			}
			
			
			
			
		} catch (Exception e) {
			//e.printStackTrace();
			log.info("there is a problem 2");

		}
	return null;
	}
	
	@GetMapping("/quantite")
	public Iterable<Produit> getStock(@RequestParam(name = "a", required = false) String prixGreat,
			@RequestParam(name = "b", required = false) String prixInf,
			@RequestParam(name = "c", required = false) String c, @RequestParam(name = "d", required = false) String d,
			@RequestParam(name = "e", required = false) String e,
			@RequestParam(name = "f", required = false) String f) {
		QProduit produit = QProduit.produit;
		BooleanBuilder where = new BooleanBuilder();
		if (prixGreat != null) {
			double prix = Double.parseDouble(prixGreat);
			where.and(produit.prix.goe(prix));
		} else if (prixInf != null) {
			double prix = Double.parseDouble(prixInf);
			where.and(produit.prix.loe(prix));
		}
		return produitRepository.findAll(where);
	}

	@GetMapping("/prix")
	public Example<Produit> getAllStock(@RequestParam(name = "p", required = false) double prix) {
		Produit p = new Produit();
		p.setPrix(prix);

		Example<Produit> example = Example.of(p);

		return  example;
	}

}
