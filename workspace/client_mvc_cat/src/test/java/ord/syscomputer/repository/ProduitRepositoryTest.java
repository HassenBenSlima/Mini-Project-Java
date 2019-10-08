package ord.syscomputer.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import ord.syscomputer.dao.ProduitRepository;
import ord.syscomputer.entities.Produit;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProduitRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(ProduitRepositoryTest.class);

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ProduitRepository repository;

	@Test
	public void findByDesignationShouldReturnProduit() throws Exception {
		logger.debug("hassen ben slima");
		this.entityManager.persist(new Produit("good", 20, 20));

		Produit p = this.repository.findByDesignation("good");
		logger.debug(p.getDesignation());
		assertThat(p.getDesignation()).isEqualTo("good");
		assertThat(p.getPrix()).isEqualTo(20);

	}

	@Test
	public void findByDesignationWhenNoProduitShouldReturnNull() throws Exception {
		this.entityManager.persist(new Produit("good", 20, 20));
		Produit p = this.repository.findByDesignation("minnie Mouse");
		assertThat(p).isNull();
	}

}
