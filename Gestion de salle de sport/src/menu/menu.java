package menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ajouter.AjouteCoach;
import Ajouter.AjouterClient;
import Ajouter.AjouterSport;
import ListePersonne.ListePersonne;
import connexion.login;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;

public class menu extends JFrame implements ActionListener {

	private JPanel contentPane;
	static JLabel zoneT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					menu frame = new menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menu() {
		setResizable(false);
		setTitle("Gestion Salle de  Sport");
		setSize(600, 400);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 550, 114);
		contentPane.add(panel);
		panel.setLayout(null);
		 setSize(550, 400);
		JLabel lblNewLabel = new JLabel("Gesstion Salle de sport");
		
		lblNewLabel.setFont(new Font("Monaco", Font.PLAIN, 17));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(60, 23, 285, 69);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/waelkamel/eclipse-workspace/projet java/image/running (2).png"));
		lblNewLabel_1.setBounds(20, 23, 52, 69);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login obj = new login();
		        obj.setVisible(true);

			}
		});
		btnNewButton_1.setIcon(new ImageIcon("/Users/waelkamel/eclipse-workspace/projet java/image/plan-de-deconnexion.png"));
		btnNewButton_1.setBounds(446, 6, 98, 29);
		panel.add(btnNewButton_1);
		
		JButton ajouteA = new JButton("");
		ajouteA.setIcon(new ImageIcon("/Users/waelkamel/eclipse-workspace/projet java/image/subscriber.png"));
		ajouteA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AjouterClient frame = new AjouterClient();
				
				frame.setVisible(true);
				
				
			}
		});
		ajouteA.setBounds(154, 159, 119, 152);
		contentPane.add(ajouteA);
		
		JButton ajouterS = new JButton("");
		ajouterS.setIcon(new ImageIcon("/Users/waelkamel/eclipse-workspace/projet java/image/sport (1).png"));
		ajouterS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AjouterSport frame = new AjouterSport();
				frame.setVisible(true);
			}
		});
		ajouterS.setBounds(23, 159, 119, 152);
		contentPane.add(ajouterS);
		
		JButton listeC = new JButton("");
		listeC.setIcon(new ImageIcon("/Users/waelkamel/eclipse-workspace/projet java/image/client.png"));
		listeC.setBounds(279, 159, 119, 152);
		contentPane.add(listeC);
		listeC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListePersonne frame = new ListePersonne();
				frame.setVisible(true);
			}
		});
		
		JButton ajouteC = new JButton("");
		ajouteC.setBounds(410, 159, 119, 152);
		contentPane.add(ajouteC);
		ajouteC.setIcon(new ImageIcon("/Users/waelkamel/eclipse-workspace/projet java/image/coach.png"));
		
		ajouteC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				
				AjouteCoach frame = new AjouteCoach();
				frame.setVisible(true);
			}
		});
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	
		
	
	
}
