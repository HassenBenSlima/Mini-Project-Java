package ord.syscomputer.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ord.syscomputer.Factory.CategorieFactory;
import ord.syscomputer.Factory.ProduitFactory;
import ord.syscomputer.Service.ProduitService;
import ord.syscomputer.dao.ProduitRepository;
import ord.syscomputer.dto.CategorieDto;
import ord.syscomputer.dto.ProduitDTO;
import ord.syscomputer.entities.Categorie;
import ord.syscomputer.entities.Produit;

public class ProduitServiceTest {

	@Mock
	private ProduitRepository produitRepository;
	@Mock
	private ProduitService produitService;
	@Mock
	private ProduitFactory produitFactory;
	@Mock
	private CategorieFactory categorieFactory;

	private Produit produit;
	private ProduitDTO produitDto;
	private Categorie categorie;
	private CategorieDto categorieDto;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.produitService = new ProduitService(produitRepository);

		produitDto = new ProduitDTO();
		categorieDto = new CategorieDto();

		produitDto.setIdDTO(5L);
		produitDto.setDesignation("code Saisie");
		produitDto.setPrix(500);
		produitDto.setQuantite(200);

		produit = new Produit();

		produit.setId(1L);
		produit.setDesignation("code Saisie");
		produit.setPrix(500);
		produit.setQuantite(200);
	}

	@Test
	public void findOneProduit() {

		given(this.produitRepository.findOne(anyLong())).willReturn(produit);

		ProduitDTO dto = produitService.findOne(1L);
		assertThat(dto.getDesignation()).isEqualTo("code Saisie");
	}

	@Test
	public void saveProduit() {
		produitDto.setCategorieDto(null);
		this.thrown.expect(NullPointerException.class);
		this.produitService.save(produitDto);
	}

}
