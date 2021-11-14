package opticien;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

public class table extends AbstractTableModel {

	String col[]= { "id", "CIN","Nom","Prénom","Addresse","N° Telephone","sexe"};
	List<patient> liste=new ArrayList<>();
	
	@Override
	public int getColumnCount() {
		return col.length;
	}

	@Override
	public int getRowCount() {
		return liste.size();
	}

	@Override
	public Object getValueAt(int l, int c) {
		switch(c) {
		case 0: return liste.get(l).getId();
		case 1: return liste.get(l).getSexe();
		case 2: return liste.get(l).getCin();
		case 3: return liste.get(l).getNom();
		case 4: return liste.get(l).getPrenom();
		case 5: return liste.get(l).getAddresse();	
		case 6: return liste.get(l).getTelephone();
		
		}
		return null;
	}
	
	public String getColumnName(int column) {
		return col[column];
	}
	
	public void charger(List<patient> l) {
		liste=l;
		fireTableDataChanged();
	}

	public static ListSelectionModel getSelectionModel() {
		
		return null;
	}

	public static void addTableModelListener(MouseAdapter mouseAdapter) {
		
		
	}

	void removeRow(int row){
		        int [] remover = new int[1];
		        remover[0]=row;
		        liste.remove(remover);
		        fireTableDataChanged();
		    }

	
}