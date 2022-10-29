package Ajouter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connexion.ConnexionBd;
import connexion.login;
import menu.menu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class AjouterSport extends JFrame implements ActionListener {

	private JPanel contentPane;
	static JLabel zoneT;
	private JTextField nomS;
	private JTextField CodeS;
	Connection cn = null;
	Statement st = null;
int rs = 0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AjouterSport frame = new AjouterSport();
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
	public AjouterSport() {
		setResizable(false);
		setTitle("Gestion Salle de  Sport");
		setSize(600, 400);
		zoneT = new JLabel(" ");
		Container c = getContentPane();
		c.setLayout(new GridLayout(4, 1));
		c.add(zoneT);
		  
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
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu frame = new menu();
				frame.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("/Users/waelkamel/eclipse-workspace/projet java/image/fleche-gauche (2).png"));
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(6, 6, 98, 29);
		panel.add(btnNewButton);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.DARK_GRAY);
		panel_1.setBounds(0, 114, 550, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Ajoutee Sport :");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(6, 24, 227, 30);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBounds(0, 174, 550, 198);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nom Sport");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(149, 47, 102, 16);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Code sport");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(149, 119, 117, 16);
		panel_2.add(lblNewLabel_4);
		
		nomS = new JTextField();
		nomS.setBounds(286, 42, 130, 26);
		panel_2.add(nomS);
		nomS.setColumns(10);
		
		CodeS = new JTextField();
		CodeS.setBounds(286, 114, 130, 26);
		panel_2.add(CodeS);
		CodeS.setColumns(10);
		
		JButton connexion = new JButton("Valider");
		connexion.setForeground(Color.BLACK);
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		connexion.setBackground(Color.BLUE);
		connexion.setBounds(427, 163, 117, 29);
		panel_2.add(connexion);
		 connexion.addActionListener(this);
			setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nom =nomS.getText();
		String code = CodeS.getText();
		Connection cn = ConnexionBd.getConnexion();
		try {
			// Création d’un statement
			st = cn.createStatement();
			// Exécution des requêtes : Insertion de données
			rs = st.executeUpdate(
					"INSERT INTO `sport` VALUES ('"+nom+"','"+code+"')");

			if (rs==1) {
				JOptionPane.showMessageDialog(null, " sport ajouter");
				
				setVisible(false);
				menu frame = new menu();
				frame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null,
						"merci de verfier les information");
			}
		} catch (SQLException v) {
			v.printStackTrace();
		}
	}
	}

