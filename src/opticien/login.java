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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener{
	ImageIcon img = new ImageIcon("..\\Mproject/580429.jpg");
	private Connection connection=null ;
	private java.sql.Statement smt=null;
	private int rs;
	
	JLabel l =new JLabel();
	JLabel ent=new JLabel("Connectez-vous");
	JLabel login=new JLabel("Identifiant :");
	JLabel mdp=new JLabel("Mot de Passe :");
	JTextField logintxt=new JTextField();
	JPasswordField mdptxt=new JPasswordField();
	JButton valider= new JButton("Valider");
	JButton inscri=new JButton("S'inscrire");
	JPanel p3=new JPanel();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel(new GridLayout(2,2,10,1));
	JPanel mainp=new JPanel(new GridLayout(2,1));
	
	public login(){
		JLabel labelimage = new JLabel(img);
    	this.add(labelimage,BorderLayout.NORTH);
		
		setTitle("Login");
		
		mainp.add(ent);
		
		p1.add(valider);
		p1.add(inscri);
		p2.add(login);
		p2.add(logintxt);
		p2.add(mdp);
		p2.add(mdptxt);

		mainp.add(p2);

		ent.setHorizontalAlignment(JLabel.CENTER);
		ent.setFont(new Font("Arial",Font.BOLD,20));
		ent.setForeground(Color.red);
		logintxt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mdptxt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		inscri.addActionListener(this);
		valider.addActionListener(this);
		
		
		login.setFont(new Font("Arial", Font.BOLD, 20));
		login.setHorizontalAlignment(JLabel.CENTER);
		mdp.setFont(new Font("Arial", Font.BOLD, 20));
		mdp.setHorizontalAlignment(JLabel.CENTER);
		logintxt.setFont(new Font("Arial", Font.PLAIN, 20));
		mdptxt.setFont(new Font("Arial", Font.PLAIN, 20));
		
		this.add(mainp,BorderLayout.CENTER);
		this.add(p1,BorderLayout.SOUTH);
		this.setResizable(true);
		this.setSize(350,270);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
	
	
	
	
	public static void main(String[] args) {
		new login();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		JButton action=(JButton) e.getSource();
		String pseudo =logintxt.getText();
		String passe= mdptxt.getText();
		
		
		if(action==inscri) {
			new inscriadmin();
			this.setVisible(false);
		}
		
		connection=BDConnexion.getConnection();
		
		
		try {
		
		if(action==valider) {
			
			if(pseudo.equals("")||passe.equals("")){
				
			      JOptionPane.showMessageDialog(null, "Veuillez Remplir les champs !","",JOptionPane.WARNING_MESSAGE);
			}
			
			else {
				
				PreparedStatement ps=connection.prepareStatement("SELECT * From admin where ide=? And Mp=? ");
				ps.setString(1,pseudo);
				ps.setString(2,passe);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					JOptionPane.showMessageDialog(null,"Login successfully");
					admin a2= new admin (rs.getString("ide"),rs.getString("Mp"),rs.getString("Nom"),rs.getString("Prenom"));
					new iinterface(a2);
					this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "identifiant ou mot de passe incorrecte");
				}
				
			}
			
		}
		}
		catch(SQLException e3){
			
		}
		
	}

}