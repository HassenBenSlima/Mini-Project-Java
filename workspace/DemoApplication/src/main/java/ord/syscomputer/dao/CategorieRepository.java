package ord.syscomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ord.syscomputer.entities.Categorie;
import ord.syscomputer.entities.Produit;
public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	
	@Query("select p from Produit p where p.categorie.idCategorie=:x")
	public List<Produit> getListProduit(@Param("x")Long idCat);
	
	
}
