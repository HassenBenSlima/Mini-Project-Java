package ord.syscomputer.Service;

import ord.syscomputer.Factory.CategorieFactory;
import ord.syscomputer.Factory.ProduitFactory;
import ord.syscomputer.dao.CategorieRepository;
import ord.syscomputer.dao.ProduitRepository;
import ord.syscomputer.dto.CategorieDto;
import ord.syscomputer.dto.ProduitDTO;
import ord.syscomputer.entities.Categorie;
import ord.syscomputer.entities.Produit;
import ord.syscomputer.util.RestPreconditions;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategorieService {

	private final CategorieRepository categorieRepository;
	private final ProduitRepository produitRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public CategorieService(CategorieRepository categorieRepository, ProduitRepository produitRepository) {

		this.categorieRepository = categorieRepository;
		this.produitRepository = produitRepository;
	}

	@Transactional(readOnly = true)
	public List<CategorieDto> findAll() {
		List<Categorie> categories = categorieRepository.findAll();
		List<CategorieDto> categorieDtos = CategorieFactory.categorieToCategorieDtos(categories);
		return categorieDtos;

	}

	public CategorieDto save(CategorieDto categorieDto) {

		Categorie categorie = CategorieFactory.categorieDtoToCategorie(categorieDto);

		List<Produit> prodList = new ArrayList<>();

		for (ProduitDTO prodDto : categorieDto.getListProduitsDto()) {
			Produit   p = produitRepository.findOne(prodDto.getIdDTO());
			//p = ProduitFactory.produitDtoToProduit(prodDto);
			p.setCategorie(categorie);

			prodList.add(p);
		}

		categorie.setProduits(prodList);
		System.out.println("-------1-------");
		categorie.getProduits().forEach(x -> System.out.println(x.getDesignation()));

		Categorie savedCategorie = categorieRepository.save(categorie);

		System.out.println("-------2-------");
		savedCategorie.getProduits().forEach(x -> System.out.println(x.getDesignation()));

		CategorieDto dto = CategorieFactory.categorieToCategorieDto(savedCategorie);
		System.out.println("-------3-------");
		dto.getListProduitsDto().forEach(x -> System.out.println(x.getDesignation()));

		return dto;
	}

	public CategorieDto update(CategorieDto categorieDto) {
		System.out.println("1");

		Categorie categorie = categorieRepository.findOne(categorieDto.getIdCategorie());

		RestPreconditions.checkFound(categorie, "Categorie not found");

		System.out.println("2");

		categorie.setNomCategorie(categorieDto.getNomCategorie());

		System.out.println("3");

		Collection<Produit> prods = new ArrayList<>();

		categorieDto.getListProduitsDto().forEach(x -> {
			Produit p = new Produit();
			p = ProduitFactory.produitDtoToProduit(x);
			p.setCategorie(categorie);
			prods.add(p);
		});
		System.out.println("----------4---------------");

		prods.forEach(x -> {
			System.out.println(x.getDesignation());
		});

		System.out.println("--------------1--------------");

		categorie.getProduits().forEach(x -> {
			System.out.println(x.getId());
		});

		if (!(categorie.getProduits().isEmpty())) {
			categorie.getProduits().clear();
			categorie.getProduits().addAll(prods);
			System.out.println("--------------2--------------");

			categorie.getProduits().forEach(x -> {
				System.out.println(x.getCategorie().getIdCategorie());

			});

		} else {
			// categorie.setProduits(prods);
			categorie.getProduits().addAll(prods);

			System.out.println("--------------3--------------");

			categorie.getProduits().forEach(x -> {
				System.out.println(x.getId());
				System.out.println("cat : " + x.getCategorie().getIdCategorie());
			});

		}

		Categorie cat = categorieRepository.save(categorie);

		CategorieDto dto = CategorieFactory.categorieToCategorieDto(cat);
		dto.getListProduitsDto().forEach(x -> System.out.println(x.getPrix()));
		;
		return dto;
	}

	public CategorieDto findOne(Long id) {
		Categorie categorie = categorieRepository.findOne(id);
		RestPreconditions.checkFound(categorie, "Categorie not found");

		CategorieDto dto = CategorieFactory.categorieToCategorieDto(categorie);
		return dto;
	}

	public void delete(Long id) {
		categorieRepository.delete(id);
	}

	public List<ProduitDTO> getProduitsByCat(Long idCat) {
		List<Produit> prodsCat = categorieRepository.getListProduit(idCat);
		List<ProduitDTO> prodsCatDto = ProduitFactory.produitsToproduitsDtos(prodsCat);
		return prodsCatDto;

	}

}