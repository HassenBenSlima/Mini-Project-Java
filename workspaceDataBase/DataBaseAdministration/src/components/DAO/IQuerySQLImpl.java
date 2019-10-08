package components.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import components.DB.SingletonConnection;
import net.proteanit.sql.DbUtils;

public class IQuerySQLImpl implements IQuerySQL {

	@Override
	public void getrequets(String req, JTable jtable) {

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(req);

			ResultSet rs = ps.executeQuery();

			jtable.setModel(DbUtils.resultSetToTableModel(rs));

			ps.close();
		} catch (

		SQLException e) {
			JOptionPane.showMessageDialog(null, "Verifiez votre requet");
			// e.printStackTrace();
		}

	}

}
