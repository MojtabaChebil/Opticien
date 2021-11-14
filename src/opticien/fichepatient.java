package opticien;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.print.*;
import javax.swing.*;


public class fichepatient extends JFrame implements ActionListener,Printable {
	
	private Connection connection=null ;
	
	static patient g=new patient();
	
	
	
	/*-------------------------------------------------------*/
	
	JLabel l10=new JLabel("Consultant");
	JLabel l10_1=new JLabel();
	JLabel l11=new JLabel();
	JLabel l11_1=new JLabel();
	
	
	JButton modifier=new JButton("Modifier");
	JButton fermer=new JButton("Fermer");
	JButton imprimer=new JButton("Imprimer");
	JButton sauvegarder=new JButton("Sauvegarder");
	
	JPanel p1=new JPanel(new BorderLayout());
	JPanel p1_1=new JPanel(new GridLayout(9,2));JPanel p1_2=new JPanel();JPanel p1_3=new JPanel();JPanel p1_4=new JPanel();
	
	
	JPanel main=new JPanel(new GridLayout(2,1));
	JPanel btn=new JPanel();
	

	
	
	
	public fichepatient() {
		
		
	}
	
	
	public fichepatient(patient g) {
		
		setTitle("Fiche Patient");
		this.setSize(50,40);
		JLabel titre=new JLabel("Fiche du Patient");
		JLabel info=new JLabel("Information du patient :");
		JLabel cons=new JLabel("Consultant :");
		JLabel l1=new JLabel("Nom :");
		JTextField tnom=new JTextField(g.getNom()+""); 
		JLabel l2=new JLabel("Prénom :");
		JTextField tprenom=new JTextField(g.getPrenom()+""); 
		JLabel l3=new JLabel("CIN :");
		JTextField tcin=new JTextField(g.getCin()+""); 
		JLabel l4=new JLabel("Sexe :");
		JTextField tsexe=new JTextField(g.getSexe()+""); 

		JLabel l6=new JLabel("Addresse :");
		JTextField tadr=new JTextField(g.getAddresse()+""); 

		JLabel l8=new JLabel("N° Telephone :");
		JTextField tntel=new JTextField(g.getTelephone()+""); 

		
		JLabel l12=new JLabel("Docteur:");
		JTextField tdoc=new JTextField(g.getDocteur());
		JLabel l12_2=new JLabel("Date d'arrivée:");
		JTextField tda=new JTextField(g.getDatearrive());
		
		
		JLabel l13_0=new JLabel();
		JLabel l13=new JLabel("OD");
		
		
		JLabel l14=new JLabel("OG");
		
		
		
		JLabel emp0=new JLabel();
		JLabel emp1=new JLabel();
		JLabel emp2=new JLabel();
		JLabel emp3=new JLabel();
		
		
		tdoc.setColumns(10);
		tda.setColumns(10);
		
		
		
		titre.setFont(new Font("Arial", Font.BOLD, 28));
		titre.setForeground(Color.green);
		titre.setHorizontalAlignment(JLabel.CENTER);
		
		info.setFont(new Font("Arial", Font.BOLD, 18));
		info.setForeground(Color.BLUE);
		cons.setFont(new Font("Arial", Font.BOLD, 18));
		cons.setForeground(Color.BLUE);
		p1.setBackground(Color.WHITE); 
		p1_1.setBackground(Color.WHITE); 
		p1_2.setBackground(Color.WHITE); 
		p1_3.setBackground(Color.WHITE); 
		p1_4.setBackground(Color.WHITE); 
	
		btn.setBackground(Color.WHITE); 
		
		
		tnom.setEditable(false);
		tprenom.setEditable(false);
		tcin.setEditable(false);
		tsexe.setEditable(false);
		
		tadr.setEditable(false);
		
		tntel.setEditable(false);
		
		tdoc.setEditable(false);
		tda.setEditable(false);
		
		
		
		tnom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tprenom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tcin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tsexe.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		tadr.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
		tntel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		tdoc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tda.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		tnom.setFont(new Font("Arial", Font.PLAIN, 14));
		tprenom.setFont(new Font("Arial", Font.PLAIN, 14));
		tcin.setFont(new Font("Arial", Font.PLAIN, 14));
		tsexe.setFont(new Font("Arial", Font.PLAIN, 14));
		
		tadr.setFont(new Font("Arial", Font.PLAIN, 14));
	
		tntel.setFont(new Font("Arial", Font.PLAIN, 14));
		
		tdoc.setFont(new Font("Arial", Font.PLAIN, 14));
		tda.setFont(new Font("Arial", Font.PLAIN, 14));
		
		l13.setHorizontalAlignment(JLabel.CENTER);
		l14.setHorizontalAlignment(JLabel.CENTER);
		
		p1_1.add(l1);
		p1_1.add(tnom);
		p1_1.add(l2);
		p1_1.add(tprenom);
		p1_1.add(l3);
		p1_1.add(tcin);
		p1_1.add(l4);
		p1_1.add(tsexe);
		
		p1_1.add(l6);
		p1_1.add(tadr);
	
		p1_1.add(l8);
		p1_1.add(tntel);
		
		
		p1.add(info , BorderLayout.NORTH);
		p1.add(p1_1 , BorderLayout.CENTER);
		p1.add(p1_2, BorderLayout.SOUTH);
		p1.add(p1_3, BorderLayout.EAST);
		p1.add(p1_4, BorderLayout.WEST);
		
		
	
		btn.add(modifier);
		btn.add(sauvegarder);
		btn.add(imprimer);
		btn.add(fermer);
		sauvegarder.setEnabled(false);
		
		main.add(p1);
		/*main.add(p2);*/
		
		
		
		this.getContentPane().setBackground(Color.white);
		this.add(titre, BorderLayout.NORTH);
		this.add(main,BorderLayout.CENTER);
		this.add(btn, BorderLayout.SOUTH);
		
		modifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==modifier) {
					
					tnom.setEditable(true);
					tprenom.setEditable(true);
					tcin.setEditable(true);
					tsexe.setEditable(true);
					
					tadr.setEditable(true);
				
					tntel.setEditable(true);
					
					tdoc.setEditable(true);
					tda.setEditable(true);
					
					
					sauvegarder.setEnabled(true);
					
					
					
				}}});
					
		sauvegarder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==sauvegarder) {	
					
					
					if (tnom.getText().equals("")||tprenom.getText().equals("")||
							tcin.getText().equals("")||tsexe.getText().equals("")
							||tadr.getText().equals("")||tntel.getText().equals("")||tdoc.getText().equals("")||tda.getText().equals("")
							)
					{JOptionPane.showMessageDialog(null, "Veillez Remplir les champs !","",JOptionPane.WARNING_MESSAGE);}
					
					else {
						
					connection=BDConnexion.getConnection();
	
		        try {
		      
		        	 PreparedStatement ps=connection.prepareStatement("UPDATE patient SET (Cin = ?, Nom = ?,Prenom = ?,Addr = ?)"
		        	 		+ "Ntel = ?,Sexe = ?,Docteur = ?,DateArrive= ?"
		        	 		+ " where id='"+g.getId()+"' "
		        			 );
		        	 	ps.setString(1,tnom.getText());
		        	 	ps.setString(2,tprenom.getText());
		        	 	ps.setString(3,tcin.getText());
		        	 	ps.setString(4,tsexe.getText());		        	 	
		        	 	ps.setString(6,tadr.getText());   	 	
		        	 	ps.setString(8,tntel.getText());
		        	 	ps.setString(10,tdoc.getText());
		        	 	ps.setString(11,tda.getText());
						ps.executeUpdate();
						System.out.println("ok");
						
						JOptionPane.showMessageDialog(null, "Modification Réussite !","",JOptionPane.INFORMATION_MESSAGE);
						
		         }
		        
		        catch (SQLException e3) {
		        	
		        }
				}
				}
			}
	
		});

		imprimer.addActionListener(this);
		fermer.addActionListener(this);
		sauvegarder.addActionListener(this);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		this.setSize(500,600);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
	}

	public static void main(String[] args) {
		
		fichepatient f =new fichepatient(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==imprimer) {
		PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                 job.print();
            } catch (PrinterException ex) {

            }
        }
		}
	
		if (e.getSource()==fermer){
	       	 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	       	 setVisible(false);
	       	 this.dispose();
	        }
		
		
			
		}

	

	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
		// TODO Auto-generated method stub
		
		if (page > 0) {
            return NO_SUCH_PAGE;
        }
 
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY()+20);
 
        this.print(g);
 
        return PAGE_EXISTS;
		
		
		
	
	}
		
		
		
	}

