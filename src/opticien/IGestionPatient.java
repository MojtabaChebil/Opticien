package opticien;

import java.util.List;

public interface IGestionPatient {

	patient ajouterPatient(patient p);
	List<patient> rechercherParCin(String cin);
	void trierPatient();
	List<patient> listeDesPatients();
}