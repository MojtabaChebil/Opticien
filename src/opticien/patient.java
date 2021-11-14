package opticien;

/*import java.util.Date;*/

public class patient implements Comparable<patient> {
	
		
		private int id;		
		private String Cin,Nom,Prenom,Addr,Ntel,sexe,Docteur,DateArrive;
		
	
		
		
		
		public patient(int id,  String sexe, String Cin, String Nom, String Prenom,
				String Addr, String Ntel,  String Docteur,
				String DateArrive) {
			super();
			this.id = id;
			this.Cin = Cin;
			this.Nom = Nom;
			this.Prenom = Prenom;
			this.Addr = Addr;
			this.Ntel = Ntel;
			this.sexe = sexe;
			this.Docteur = Docteur;
			this.DateArrive=DateArrive;
		}

		public patient() {
			// TODO Auto-generated constructor stub
		}

		
		
		public String getDatearrive() {
			return DateArrive;
		}
		
		public void setDatearrive(String datearrive) {
			this.DateArrive = datearrive;
		}
		
		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCin() {
			return Cin;
		}

		public void setCin(String Cin) {
			this.Cin = Cin;
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

		

		public String getAddresse() {
			return Addr;
		}

		public void setAddresse(String Addr) {
			this.Addr = Addr;
		}

		public String getTelephone() {
			return Ntel;
		}

		public void setTelephone(String Ntel) {
			this.Ntel = Ntel;
		}

		public String getSexe() {
			return sexe;
		}

		public void setSexe(String sexe) {
			this.sexe = sexe;
		}

		
		public String getDocteur() {
			return Docteur;
		}

		public void setDocteur(String Docteur) {
			this.Docteur = Docteur;
		}

		

		@Override
		public int compareTo(patient p) {
			// TODO Auto-generated method stub
			if(this.Nom.compareTo(p.Nom)==0) 
				return Prenom.compareTo(p.Prenom);
			return this.Nom.compareTo(p.Nom);
		}
		
}