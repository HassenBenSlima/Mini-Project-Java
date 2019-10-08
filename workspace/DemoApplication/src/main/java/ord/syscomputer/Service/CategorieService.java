package ord.syscomputer.Service;
import ord.syscomputer.Factory.CategorieFactory;
import ord.syscomputer.Factory.ProduitFactory;
import ord.syscomputer.dao.CategorieRepository;
import ord.syscomputer.dao.ProduitRepository;
import ord.syscomputer.dto.CategorieDto;
import ord.syscomputer.dto.ProduitDto;
import ord.syscomputer.entities.Categorie;
import ord.syscomputer.entities.Produit;
import ord.syscomputer.util.RestPreconditions;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.base.Preconditions;

@Service
@Transactional
public class CategorieService {

	private static final Logger log = LoggerFactory.getLogger(CategorieService.class);
	private final CategorieRepository categorieRepository;
	private final ProduitRepository produitRepository;
	@Value("${delete-categorie-without-check}")
	private boolean deleteCategorieWithoutCheck;

	public CategorieService(CategorieRepository categorieRepository, ProduitRepository produitRepository) {

		this.categorieRepository = categorieRepository;
		this.produitRepository = produitRepository;
	}

	public CategorieDto findOne(Long id) {
		Categorie categorie = categorieRepository.findOne(id);
		RestPreconditions.checkFound(categorie, "Categorie not found");

		CategorieDto dto = CategorieFactory.categorieToCategorieDto(categorie);
		return dto;
	}

	@Transactional(readOnly = true)
	public List<CategorieDto> findAll() {
		List<Categorie> categories = categorieRepository.findAll();
		List<CategorieDto> categorieDtos = CategorieFactory.categorieToCategorieDtos(categories);
		return categorieDtos;

	}

	public CategorieDto save(CategorieDto categorieDto) {
		Categorie categorie = CategorieFactory.categorieDtoToCategorie(categorieDto);
		Categorie savedCategorie = categorieRepository.save(categorie);
		CategorieDto dto = CategorieFactory.categorieToCategorieDto(savedCategorie);
		return dto;
	}

	public CategorieDto update(CategorieDto categorieDto) {
		Categorie categorie = categorieRepository.findOne(categorieDto.getIdCategorie());
		Preconditions.checkArgument(categorie != null, "Categorie has been deleted");
		Categorie cat = categorieRepository.save(CategorieFactory.categorieDtoToCategorie(categorieDto));
		CategorieDto dto = CategorieFactory.categorieToCategorieDto(cat);
		return dto;
	}

	public void delete(Long id) {// ma3adneche el 7a9 nefse5ou categorie fiha
									// des article avec un prix (>)!=0
		// boolean deleteCategorieWithoutCheck = true;// c'est un variable
		// static
		// mais si on le met dans le
		// fichier de configuration
		// il devient dynamique
		Categorie categorieInBase = categorieRepository.findOne(id);
		if (categorieInBase != null && categorieInBase.getProduits() != null && !deleteCategorieWithoutCheck) {
			// optional 5ater tejem el valeur tetla3 null
			Optional<Produit> badProduit = categorieInBase.getProduits().stream()
					.filter(dto -> dto.getPrix().compareTo(BigDecimal.ZERO) != 0).findFirst();
			Preconditions.checkArgument(!badProduit.isPresent(),
					"We can't delete a categorie that have produit with price greater than 0");
			// locano is present ikamel i5arjelna erreur kenou is not present
			// ikamel excution
		}
		categorieRepository.delete(id);
	}

	public List<ProduitDto> getProduitsByCat(Long idCat) {
		List<Produit> prodsCat = categorieRepository.getListProduit(idCat);
		List<ProduitDto> prodsCatDto = ProduitFactory.produitsToproduitsDtos(prodsCat);
		return prodsCatDto;

	}

	public BigDecimal calculeAvgPrice(Long id) {
		Categorie categorieInBase = categorieRepository.findOne(id);
		Preconditions.checkArgument(categorieInBase != null, "Categorie has been deleted");
		log.info(categorieInBase.getNomCategorie());
		BigDecimal sum = BigDecimal.ZERO;
		for (Produit produit : categorieInBase.getProduits()) {
			log.info(produit.getPrix().toString());
			sum = produit.getPrix().add(sum);
		}
		return sum.divide(BigDecimal.valueOf(categorieInBase.getProduits().size()));
//		throw new UnsupportedOperationException("Not supported yet.");
	}

}