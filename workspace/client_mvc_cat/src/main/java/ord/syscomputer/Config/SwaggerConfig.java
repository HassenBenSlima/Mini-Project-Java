package ord.syscomputer.Config;
import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiParam;
import ord.syscomputer.dao.ProduitRepository;
import ord.syscomputer.entities.Produit;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@PropertySource("classpath=swagger.properties")
//@ComponentScan(basePackageClasses=CategorieRest.class)
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/*@Autowired
	private ProduitRepository produitRepository;
	private final  String allowableValues;

	public final String getAllowableValues() {
		return allowableValues;
	}


	public SwaggerConfig() {
		  List<Produit> list = produitRepository.findAll();
		  //code to get every value you need and add create comma separated String
		  StringJoiner stringJoiner = new StringJoiner(",");
		  stringJoiner.add(String.valueOf(list.get(0).getPrix()));
		  this.allowableValues = stringJoiner.toString();
		}*/
	

	 @Bean
	 public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	        		.apiInfo(apiInfo())
	        		.pathMapping("/")
	                .select()
	                .paths(PathSelectors.ant("/api/**"))
	                .build();
	    }
	 
	 private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("JavaInUse API")
				.description("JavaInUse API reference for developers")
				.license("License")
				.version("1.0").build();
	}
	 


}