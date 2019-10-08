package components.DAO;

import java.util.List;

import components.entities.Table;

public interface IMetier {

	public List<Table> getAllTables();

	public List<Table> getAllCategories();

}
