package ord.syscomputer.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.querydsl.core.types.dsl.StringPath;
import ord.syscomputer.entities.Produit;
import ord.syscomputer.entities.QProduit;
@RepositoryRestResource//(excerptProjection = ProduitDTO.class)
public interface ProduitRepository extends
JpaRepository<Produit, Long>,
QueryDslPredicateExecutor<Produit>,
QuerydslBinderCustomizer<QProduit>{

	@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> chercher(@Param("x") String mc, Pageable pageable);

	Produit findByDesignation(String des);

		@Override
	  default public void customize(QuerydslBindings bindings, QProduit produit) {
		
	   // bindings.bind(produit.designation).first((path, value) -> path.contains(value)); 
	    bindings.bind(String.class).
	    first((StringPath path, String value) -> path.containsIgnoreCase(value)); 
	    //bindings.excluding(produit.prix);                                           
	     bindings.bind(produit.prix).first((path, value) -> 
	     path.notBetween(value, value)); 
	     
	}
}