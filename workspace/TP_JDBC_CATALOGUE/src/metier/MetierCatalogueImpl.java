package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierCatalogueImpl implements IMetier {

	@Override
	public void addCategorie(Categorie c) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					("insert into CATEGORIES (NOM_CAT) values(?)");
		ps.setString(1, c.getNomCat());
		ps.executeUpdate();//executeQuery utuliser pour les requete de type select
		ps.close();
		//conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addProduit(Produit p, int idCat) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					("insert into PRODUITS values(?,?,?,?,?)");
		ps.setString(1, p.getRefProduit());
		ps.setString(2, p.getNomProduit());
		ps.setDouble(3, p.getPrix());
		ps.setInt(4, p.getQuantite());
		ps.setInt(5, idCat);
		
		ps.executeUpdate();//executeQuery utuliser pour les requete de type select
		ps.close();
		//conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produit> getProduitParMC(String mc) {
		List<Produit>prods=new ArrayList<Produit>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					("select * from PRODUITS where NOM_PRODUIT like ?");
		ps.setString(1, "%"+mc+"%");
		ResultSet rs=ps.executeQuery();
		while (rs.next()){
			Produit p =new Produit();
			p.setRefProduit(rs.getString("REF_PRODUIT"));
			p.setNomProduit(rs.getString("NOM_PRODUIT"));
			p.setPrix(rs.getDouble("PRIX"));
			p.setQuantite(rs.getInt("QUANTITE"));
			int idCat =rs.getInt("ID_CAT");
			PreparedStatement ps2=conn.prepareStatement
					("select * from CATEGORIES where  ID_CAT=?");
		ps2.setInt(1, idCat);
		ResultSet rs2=ps2.executeQuery();//pourquoi!!!
		if(rs2.next()){
		Categorie cat =new Categorie();
		cat.setIdCat(rs2.getInt("ID_CAT"));
		cat.setNomCat(rs2.getString("NOM_CAT"));
		p.setCategorie(cat);
		ps2.close();
		}
		prods.add(p);
		}
		
		ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public List<Produit> getProduitParCat(int idCat) {
		List<Produit>prods=new ArrayList<Produit>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					("select * from PRODUITS where ID_CAT=?");
		ps.setInt(1, idCat);
		ResultSet rs=ps.executeQuery();
		while (rs.next()){
			Produit p =new Produit();
			p.setRefProduit(rs.getString("REF_PRODUIT"));
			p.setNomProduit(rs.getString("NOM_PRODUIT"));
			p.setPrix(rs.getDouble("PRIX"));
			p.setQuantite(rs.getInt("QUANTITE"));
			
			PreparedStatement ps2=conn.prepareStatement
					("select * from CATEGORIES where  ID_CAT=?");
		ps2.setInt(1, idCat);
		ResultSet rs2=ps2.executeQuery();//pourquoi!!!
		if(rs2.next()){
		Categorie cat =new Categorie();
		cat.setIdCat(rs2.getInt("ID_CAT"));
		cat.setNomCat(rs2.getString("NOM_CAT"));
		p.setCategorie(cat);
		ps2.close();
		}
		prods.add(p);
		}
		 
		ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
	}
	
	@Override
	public List<Categorie> getAllCategories() {
		List<Categorie> cats=new ArrayList<Categorie>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					("select * from CATEGORIES");
		ResultSet rs=ps.executeQuery();
		while (rs.next()){
			Categorie c =new Categorie();
			c.setIdCat(rs.getInt("ID_CAT"));
			c.setNomCat(rs.getString("NOM_CAT"));
			cats.add(c);
			}
		ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cats;
	}

	@Override
	public Categorie getCategorie(int idCat) {
		Categorie cat=null;
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
					("select * from CATEGORIES where ID_CAT=?");
		ps.setInt(1, idCat);
			ResultSet rs=ps.executeQuery();
		if (rs.next()){
			cat =new Categorie();
			cat.setIdCat(rs.getInt("ID_CAT"));
			cat.setNomCat(rs.getString("NOM_CAT"));
			
			List<Produit> prods= this.getProduitParCat(idCat);
			cat.setProduits(prods);
			}
		ps.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cat;
	}

}
