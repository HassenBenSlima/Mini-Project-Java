package ord.syscomputer.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import ord.syscomputer.entities.Produit;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProduitEntityTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void createWhenDesignationIsNullShouldThrowException() throws Exception {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("designation must not be empty");
		new Produit(null, 20, 20);
	}

	@Test
	public void createWhenDesignationIsEmptyShouldThrowException() throws Exception {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("designation must not be empty");
		new Produit("", 20, 20);
	}

	@Test
	public void saveShouldPersistData() throws Exception {
		Produit prod = this.entityManager.persistFlushFind(new Produit("hassen", 20, 20));
		assertThat(prod.getDesignation()).isEqualTo("hassen");
	}

}
