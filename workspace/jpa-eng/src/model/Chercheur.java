package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CHERCHEUR database table.
 * 
 */
@Entity
@NamedQuery(name="Chercheur.findAll", query="SELECT c FROM Chercheur c")
public class Chercheur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NUM_CHERCHEUR")
	private long numChercheur;

	private String adresse;

	private String email;

	private String grade;

	private String nom;

	@Column(name="NUM_TEL")
	private BigDecimal numTel;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="chercheur")
	private List<Article> articles;

	//bi-directional many-to-one association to Laboratoire
	@ManyToOne
	@JoinColumn(name="CODE_LAB")
	private Laboratoire laboratoire;

	//bi-directional many-to-one association to UniteRecherche
	@ManyToOne
	@JoinColumn(name="NUM_UNT")
	private UniteRecherche uniteRecherche;

	//bi-directional many-to-many association to UniteRecherche
	@ManyToMany(mappedBy="chercheurs2")
	private List<UniteRecherche> uniteRecherches;

	//bi-directional many-to-one association to MissionSc
	@OneToMany(mappedBy="chercheur")
	private List<MissionSc> missionScs;

	public Chercheur() {
	}

	public long getNumChercheur() {
		return this.numChercheur;
	}

	public void setNumChercheur(long numChercheur) {
		this.numChercheur = numChercheur;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getNumTel() {
		return this.numTel;
	}

	public void setNumTel(BigDecimal numTel) {
		this.numTel = numTel;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setChercheur(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setChercheur(null);

		return article;
	}

	public Laboratoire getLaboratoire() {
		return this.laboratoire;
	}

	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}

	public UniteRecherche getUniteRecherche() {
		return this.uniteRecherche;
	}

	public void setUniteRecherche(UniteRecherche uniteRecherche) {
		this.uniteRecherche = uniteRecherche;
	}

	public List<UniteRecherche> getUniteRecherches() {
		return this.uniteRecherches;
	}

	public void setUniteRecherches(List<UniteRecherche> uniteRecherches) {
		this.uniteRecherches = uniteRecherches;
	}

	public List<MissionSc> getMissionScs() {
		return this.missionScs;
	}

	public void setMissionScs(List<MissionSc> missionScs) {
		this.missionScs = missionScs;
	}

	public MissionSc addMissionSc(MissionSc missionSc) {
		getMissionScs().add(missionSc);
		missionSc.setChercheur(this);

		return missionSc;
	}

	public MissionSc removeMissionSc(MissionSc missionSc) {
		getMissionScs().remove(missionSc);
		missionSc.setChercheur(null);

		return missionSc;
	}

}