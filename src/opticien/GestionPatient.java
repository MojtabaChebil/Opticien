package opticien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionPatient implements IGestionPatient{

	private List<patient> liste = new ArrayList<>();
	@Override
	public patient ajouterPatient(patient p) {
		liste.add(p);
		return p;
	}

	@Override
	public List<patient> rechercherParCin(String Cin) {
		
		List<patient> l=new ArrayList<>();
		for (patient p : liste)
			if(p.getNom().contains(Cin))
				l.add(p);
		return l;
				
	}

	@Override
	public void trierPatient() {
	
		Collections.sort(liste);
	}

	@Override
	public List<patient> listeDesPatients() {
		
		return liste;
	}

}