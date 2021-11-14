package opticien;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;




public class inscriadmin extends JFrame implements ActionListener{
	
	private Connection connection=null ;
	private java.sql.Statement smt=null;
	private int rs;
	
	JLabel titre=new JLabel("Inscrivez-Vous !");
	JLabel id=new JLabel("Identifiant :");
	JLabel nom=new JLabel("Nom :");
	JLabel prenom=new JLabel("Prénom :");
	JLabel mdp=new JLabel("Mot de Passe :");
	JTextField txt1=new JTextField();
	JTextField txt2=new JTextField();
	JTextField txt3=new JTextField();
	JTextField txt5=new JTextField();
	JButton inscrire=new JButton("S'inscrire");
	JButton annuler=new JButton("Annuler");

	JPanel pp=new JPanel(new FlowLayout());
	JPanel p=new JPanel(new GridLayout(4,2,2,2));
	JPanel p2=new JPanel();
	JPanel mid=new JPanel();
	
	public inscriadmin(){
		
		setTitle("INSCRIPTION");
		
		titre.setFont(new Font("Arial", Font.BOLD, 28));
		titre.setForeground(Color.gray);
		titre.setHorizontalAlignment(JLabel.CENTER);
		
		//p.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
		p.add(id);
		p.add(txt1);
		p.add(nom);
		p.add(txt2);
		p.add(prenom);
		p.add(txt3);
		p.add(mdp);
		p.add(txt5);
		pp.add(inscrire);
		pp.add(annuler);
		mid.add(p);
		mid.add(p2);
		txt1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txt2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txt3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txt5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		id.setFont(new Font("Arial", Font.BOLD, 20));
		nom.setFont(new Font("Arial", Font.BOLD, 20));
		prenom.setFont(new Font("Arial", Font.BOLD, 20));
		mdp.setFont(new Font("Arial", Font.BOLD, 20));
		txt1.setFont(new Font("Arial", Font.PLAIN, 20));
		txt2.setFont(new Font("Arial", Font.PLAIN, 20));
		txt3.setFont(new Font("Arial", Font.PLAIN, 20));
		txt5.setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		
		inscrire.addActionListener(this);
		annuler.addActionListener(this);
		this.add(titre,BorderLayout.NORTH);
		this.add(p,BorderLayout.CENTER);
		this.add(pp,BorderLayout.SOUTH);
	
		
		this.setSize(400,250);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		
		
	}
	
	public static void main(String[] args) {
		new inscriadmin();
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==annuler){
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       	 setVisible(false);
       	 this.dispose();
		}
		
		if (e.getSource()==inscrire){
			
			if (txt1.getText().equals("")||txt2.getText().equals("")||txt3.getText().equals("")||
					txt5.getText().equals("")){
				
				JOptionPane.showMessageDialog(this, "Veillez Remplir les champs !","",JOptionPane.WARNING_MESSAGE);
		}
		else{
			
		
		connection=BDConnexion.getConnection();
	
	
		
		try{
			
			PreparedStatement ps1=connection.prepareStatement("INSERT INTO admin (ide,Nom,Prenom,Mp)"
					+"Values(?,?,?,?)");
					ps1.setString(1,txt1.getText());
					ps1.setString(2,txt2.getText());
					ps1.setString(3,txt3.getText());
					ps1.setString(4,txt5.getText());
					ps1.executeUpdate();
							
				JOptionPane.showMessageDialog(null, "Inscription Réussite");
				
				new login();
				this.setVisible(false);
			
		}
		
		catch(SQLException e1){
			JOptionPane.showMessageDialog(null, "Deja Existe","",JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		}

}}
}