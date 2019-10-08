/**
 * 
 */
package ord.syscomputer.Try;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import ord.syscomputer.dao.ProduitRepository;
import ord.syscomputer.entities.Produit;

/**
 * @author asus-Hassen
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationIntegrationTest {
	@Autowired
	private ProduitRepository produitRepository;

	/*
	 * @LocalServerPort private int port;
	 */

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void TestsomeRestCall() {
		ResponseEntity<Produit> prod = this.restTemplate.getForEntity("/api/produits/{id}", Produit.class, 2);
		System.out.println(prod.getBody().getPrix());
		assertThat(prod.getBody()).isNotNull();

	}

	@Test
	public void TestProduitRestCall() {
		ResponseEntity<Produit> prod = this.restTemplate.getForEntity("http://localhost:9700/api/produits/{id}",
				Produit.class, 1);
		System.out.println(prod.getBody().getDesignation() + " other data base");
		assertThat(prod.getBody()).isNotNull();

	}

	@Test
	public void test() {

		Produit response = this.produitRepository.findOne(2L);
		System.out.println(response.getDesignation());
		assertThat(response.getDesignation()).isNotNull().contains("Sumsung Galaxy");
	}

}
