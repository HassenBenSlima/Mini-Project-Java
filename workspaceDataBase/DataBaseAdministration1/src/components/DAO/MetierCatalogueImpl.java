package components.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import components.DB.SingletonConnection;
import components.entities.Table;

public class MetierCatalogueImpl implements IMetier {
	@Override
	public List<Table> getAllTables() {
		List<Table> tables = new ArrayList<Table>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT table_name FROM user_tables");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Table table = new Table();

				table.setTableName("table_name");

				tables.add(table);
			}
			ps.close();

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		return tables;
	}

	@Override
	public List<Table> getAllCategories() {
		List<Table> tables = new ArrayList<Table>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT table_name FROM user_tables");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Table table = new Table();
				table.setTableName(rs.getString("table_name"));

				tables.add(table);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tables;
	}

	public static void main(String[] args) {
		List<Table> tab = new MetierCatalogueImpl().getAllCategories();

		for (Table table : tab) {
			System.out.println(table.toString());
		}
	}

}
