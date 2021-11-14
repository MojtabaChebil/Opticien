package opticien;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;




public class iinterface extends JFrame implements ActionListener, ListSelectionListener{
	private Connection connection=null ;
	static admin a2=new admin();
	JLabel titre=new JLabel("Gestion des patients");
	JLabel l3=new JLabel("Sexe: ");
	JRadioButton r1=new JRadioButton("Masculin");
	JRadioButton r2=new JRadioButton("Feminin");
	ButtonGroup bgg=new ButtonGroup();
	JLabel cin=new JLabel("CIN: ");
	JTextField tcin=new JTextField();
	JLabel nom=new JLabel("Nom:");
	JTextField tnom=new JTextField();
	JLabel prenom=new JLabel("Prénom:");
	JTextField tprenom=new JTextField(); 

	JLabel addr=new JLabel("Addresse:");
	JTextField taddr=new JTextField();
	JLabel ntel=new JLabel("N° de telephone:");
	JTextField tntel=new JTextField();

	JPanel rd=new JPanel();
	JPanel p1_1=new JPanel(new GridLayout(4,2));
	JPanel p1_2=new JPanel(new GridLayout(5,2));
	JPanel p1=new JPanel(new GridLayout(1,2,100,0));
	

	JLabel doc=new JLabel("Docteur:");
	JTextField tdoc=new JTextField(10);
	JLabel da=new JLabel("Date d'arrivée:");
	JTextField tda=new JTextField(10);

	JLabel l13_0=new JLabel();
	JLabel od=new JLabel("D");
	JTextField tod=new JTextField();
	JLabel og=new JLabel("G");
	JTextField tog=new JTextField();
	
	
	JLabel emp0=new JLabel();
	JLabel emp1=new JLabel();
	JLabel emp2=new JLabel();
	JLabel emp3=new JLabel();


	
	table tab=new table();
	JTable tabPatient=new JTable(tab);
	JScrollPane jsp=new JScrollPane(tabPatient);
	

	
	JButton nouveau=new JButton("Nouveau");
	JButton afficher=new JButton("Afficher les Patients");
	JButton ajouter=new JButton("Ajouter");
	
	JButton supprimer=new JButton("Supprimer");
	JButton fermer=new JButton("Fermer");

	
	JPanel p2_1=new JPanel(new FlowLayout(5,50,5));
	JPanel p2_2=new JPanel(new GridLayout(3,4));
	JPanel p2_3=new JPanel(new GridLayout(3,2));
	JPanel p2_4=new JPanel(new GridLayout(3,2));
	JPanel a=new JPanel(new GridLayout(1,3,20,20));
	JPanel btn=new JPanel();
	JPanel p2=new JPanel(new GridLayout(2,1));
	JPanel centre=new JPanel(new BorderLayout());
	JPanel main=new JPanel(new GridLayout(3,1));

	public iinterface(admin a2) {
		
		
		
		titre.setFont(new Font("Arial", Font.BOLD, 28));
		titre.setForeground(Color.ORANGE);
		titre.setHorizontalAlignment(JLabel.CENTER);
		cin.setFont(new Font("Arial", Font.PLAIN, 20));
		tnom.setFont(new Font("Arial", Font.PLAIN, 20));
		tprenom.setFont(new Font("Arial", Font.PLAIN, 20));
		taddr.setFont(new Font("Arial", Font.PLAIN, 20));
		tntel.setFont(new Font("Arial", Font.PLAIN, 20));
		tdoc.setFont(new Font("Arial", Font.PLAIN, 20));
		tda.setFont(new Font("Arial", Font.PLAIN, 20));
		r1.setFont(new Font("Arial", Font.PLAIN, 18));
		r2.setFont(new Font("Arial", Font.PLAIN, 18));
		tod.setFont(new Font("Arial", Font.PLAIN, 20));
		tog.setFont(new Font("Arial", Font.PLAIN, 20));
	
	
		l3.setFont(new Font("Arial", Font.BOLD, 20));
	
		l3.setHorizontalAlignment(JLabel.CENTER);
		cin.setFont(new Font("Arial", Font.BOLD, 20));
		cin.setHorizontalAlignment(JLabel.CENTER);
		nom.setFont(new Font("Arial", Font.BOLD, 20));
		nom.setHorizontalAlignment(JLabel.CENTER);
		prenom.setFont(new Font("Arial", Font.BOLD, 20));
		prenom.setHorizontalAlignment(JLabel.CENTER);
		addr.setFont(new Font("Arial", Font.BOLD, 20));
		addr.setHorizontalAlignment(JLabel.CENTER);
		ntel.setFont(new Font("Arial", Font.BOLD, 20));
		ntel.setHorizontalAlignment(JLabel.CENTER);
		doc.setFont(new Font("Arial", Font.BOLD, 20));
		doc.setHorizontalAlignment(JLabel.CENTER);
		da.setFont(new Font("Arial", Font.BOLD, 20));
		da.setHorizontalAlignment(JLabel.CENTER);
		
		od.setFont(new Font("Arial", Font.BOLD, 20));
		od.setHorizontalAlignment(JLabel.CENTER);
		og.setFont(new Font("Arial", Font.BOLD, 20));
		og.setHorizontalAlignment(JLabel.CENTER);
	
		bgg.add(r1);
		bgg.add(r2);
		p1_1.add(rd);
		p1_1.add(cin);
		p1_1.add(tcin);
		p1_1.add(nom);
		p1_1.add(tnom);
		p1_1.add(prenom);
		p1_1.add(tprenom);
		
		p1_2.add(addr);
		p1_2.add(taddr);

		p1_2.add(ntel);
		p1_2.add(tntel);
		p1_2.add(l3);
		rd.add(r1);
		rd.add(r2);
		p1_2.add(rd);
		
		p1.add(p1_1);
		p1.add(p1_2);
	
		
		p2_1.add(doc);
		p2_1.add(tdoc);
		p2_1.add(da);
		p2_1.add(tda);
	
		
	
		p2_2.add(od);
		p2_2.add(tod);
		
		p2_2.add(og);
		p2_2.add(tog);
		
		p2_3.add(emp0);
		p2_3.add(emp1);

		p2_4.add(emp2);
		p2_4.add(emp3);
		a.add(p2_2);
		a.add(p2_3);
		a.add(p2_4);
		p2.add(p2_1);
		p2.add(a);
	
		
		btn.add(nouveau);
		btn.add(afficher);
		btn.add(ajouter);
		
		btn.add(supprimer);
		btn.add(fermer);
		
		centre.add(p2,BorderLayout.CENTER);
		

		
		main.add(p1);
		main.add(centre);
		main.add(jsp);
		
		 p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Patient"));
	     centre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Consultant"));
	     jsp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Liste des patients")); 
	     tabPatient.setRowSelectionAllowed(true);
	     tabPatient.setColumnSelectionAllowed(false);
	 
	
		

	    nouveau.addActionListener(this);
	    afficher.addActionListener(this);
	    ajouter.addActionListener(this);

	    supprimer.addActionListener(this);
	    fermer.addActionListener(this);
	    
	    //Affiche Liste
	    ListSelectionModel listMod =  tabPatient.getSelectionModel();
	    listMod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    listMod.addListSelectionListener(this);
	    
	    tabPatient.addMouseListener(new MouseAdapter(){
	        public void mouseClicked(MouseEvent e){
	        	connection=BDConnexion.getConnection();	

	        	int i=tabPatient.getSelectedRow();
	        	String selected = tab.getValueAt(i, 0).toString();
	        	
	        try {
	         if (e.getClickCount() == 2){
	        	 
	        	 PreparedStatement ps=connection.prepareStatement("Select * from patient where id='"+selected+"' ");
					ResultSet rst=ps.executeQuery();
					 if(rst.next()){
						 patient g=new patient(rst.getInt("id"),rst.getString("Cin"),rst.getString("Nom"),rst.getString("Prenom"),rst.getString("Addr"),
	        	            	rst.getString("Ntel"),rst.getString("sexe"),rst.getString("Docteur"),rst.getString("DateArrive"));
	        	 new fichepatient(g); 
	            }
	         }
	        }
	        catch (SQLException e3) {
	        	
	        }
	        }
	        } );
	    
	  
		this.add(titre,BorderLayout.NORTH);
		this.add(main , BorderLayout.CENTER);
		this.add(btn,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
	}	
	public static void main(String[] args) {
		new iinterface(a2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//fermer 
		if (e.getSource()==fermer){
       	 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       	 setVisible(false);
       	 this.dispose();
        }

		//Ajouter
		if (e.getSource()==ajouter){
			
			ArrayList<patient> liste = new ArrayList<>(); 

			if (tcin.getText().equals("")||tnom.getText().equals("")||
					tprenom.getText().equals("")||taddr.getText().equals("")
					||tntel.getText().equals("")||
					tdoc.getText().equals("")||tda.getText().equals("")){
				JOptionPane.showMessageDialog(this, "Veillez Remplir les champs !","",JOptionPane.WARNING_MESSAGE);}
				
				else{
					String M="masculin";
					String F="feminin";
					connection=BDConnexion.getConnection();
					try{
						PreparedStatement ps=connection.prepareStatement("INSERT INTO patient(Cin,Nom,Prenom,Addr,Ntel,Sexe,Docteur,DateArrive)"
								+"Values(?,?,?,?,?,?,?,?)");
						ps.setString(1,tcin.getText());
						ps.setString(2,tnom.getText());
						ps.setString(3,tprenom.getText());
						ps.setString(4,taddr.getText());
						ps.setString(5,tntel.getText());
						if(r1.isSelected()) {
							ps.setString(6,M);
						}
						if(r2.isSelected()) {
							ps.setString(6,F);
						}
						ps.setString(7,tdoc.getText());
						ps.setString(8,tda.getText());	
						
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Ajout Réussit");
					}
					catch(SQLException e1){
						JOptionPane.showMessageDialog(null, "Patient Non Ajout","",JOptionPane.WARNING_MESSAGE);
					}
					
				}
		}
			//Affiche P	
			if (e.getSource()==afficher) {
					
				ArrayList<patient> liste = new ArrayList<>();
				
					 try{
		        			
			        		connection=BDConnexion.getConnection();
			        			java.sql.PreparedStatement ps2=connection.prepareStatement("SELECT * From patient");
			        			ResultSet rst=ps2.executeQuery();
			        			
			        			while(rst.next()){
			        			
			        				patient p=new patient(rst.getInt("id"),rst.getString("Cin"),rst.getString("Nom"),rst.getString("Prenom"),rst.getString("Addr"),
			        	            		rst.getString("Ntel"),rst.getString("sexe"),rst.getString("Docteur")
			        	            		,rst.getString("DateArrive")
			        						
			        						);
			        				liste.add(p);
			        			}
			        			
			      tab.charger(liste);
			      }			
			        	catch (SQLException ee){
			        			   System.out.println(ee);
			        			}
		
                   	}
		//vide
		if(e.getSource()==nouveau) {
			tcin.setText("");tnom.setText("");tprenom.setText("");taddr.setText("");
			tntel.setText("");tdoc.setText("");tda.setText("");
			tod.setText("");tog.setText("");
			
		}
		
		if(e.getSource()==supprimer) {	
			int i=tabPatient.getSelectedRow();
			tab.removeRow(i);
			String selected = tab.getValueAt(i, 0).toString();
			ArrayList<patient> liste = new ArrayList<>();
			  
			 try{
       			
	        		connection=BDConnexion.getConnection();
	        			java.sql.PreparedStatement ps3=connection.prepareStatement("DELETE From patient where id='"+selected+"'");
	        			ps3.executeUpdate();

	      tab.charger(liste);
			
			
			
		}
			 catch (SQLException ee){
  			   System.out.println(ee);
  			}
		}
	
}




	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	} 

	}
