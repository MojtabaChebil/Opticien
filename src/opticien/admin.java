package opticien;

public class admin {
	
	private static int nb ;
	private int id ;
	private String ide,Mp,Nom,Prenom ;


	public admin(String ide, String Mp, String Nom, String Prenom) {
		super();
		id=++nb;
		this.ide = ide;
		this.Mp = Mp;
		this.Nom = Nom;
		this.Prenom = Prenom;
	}
	
	public admin() {
		id=++nb;
	}
	public static int getNb(){
		return nb;
	}
	public int getId(){
		return id ;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String Prenom) {
		this.Prenom = Prenom;
	}

	public String getLogin() {
		return ide;
	}

	public void setLogin(String ide) {
		this.ide = ide;
	}

	public String getPass() {
		return Mp;
	}

	public void setMdp(String Mp) {
		this.Mp = Mp;
	}
	
}