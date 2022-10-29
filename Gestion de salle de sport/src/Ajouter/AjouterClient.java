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
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AjouterClient extends JFrame implements ActionListener  {
	Connection cn = null;
	java.sql.Statement st = null;
   int rs = 0;
   private String sport;

	private JPanel contentPane;
	static JLabel zoneT;
	private JTextField nomP;
	private JTextField Prenom;
	private JTextField nce;
	private JTextField DateD;
	private JTextField DateF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AjouterClient frame = new AjouterClient();
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
	public AjouterClient() {
		setResizable(false);
		setTitle("Gestion Salle de  Sport");
		setSize(600, 400);
		zoneT = new JLabel("                                                                bienvenu dans notre app");
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.DARK_GRAY);
		panel_1.setBounds(0, 114, 550, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Ajoutee Personne :");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(6, 24, 227, 30);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBounds(0, 174, 550, 198);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nom ");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(6, 6, 102, 16);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("prenom");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(6, 46, 117, 16);
		panel_2.add(lblNewLabel_4);
		
		nomP = new JTextField();
		nomP.setBounds(114, 2, 111, 26);
		panel_2.add(nomP);
		nomP.setColumns(10);
		
		Prenom = new JTextField();
		Prenom.setBounds(114, 42, 117, 26);
		panel_2.add(Prenom);
		Prenom.setColumns(10);
		
		JButton conexion = new JButton("Valider");
		conexion.setForeground(Color.BLACK);
		conexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		conexion.setBackground(Color.BLUE);
		conexion.setBounds(427, 163, 117, 29);
		panel_2.add(conexion);
		
		JLabel lblNewLabel_4_1 = new JLabel("nce");
		lblNewLabel_4_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(6, 88, 117, 16);
		panel_2.add(lblNewLabel_4_1);
		
		nce = new JTextField();
		nce.setColumns(10);
		nce.setBounds(114, 84, 117, 26);
		panel_2.add(nce);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(124, 130, 101, 27);
		panel_2.add(comboBox);
		Connection cn = ConnexionBd.getConnexion();
		java.sql.Statement st = null;
		ResultSet rs = null;
		try {
			st = cn.createStatement();
			rs = st.executeQuery("select * from sport");
			while(rs.next()) {
				comboBox.addItem(rs.getString(1));
		 sport=comboBox.getSelectedItem().toString();
		 
			}
			
			
			
			
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		JLabel lblNewLabel_4_1_1 = new JLabel("sport");
		lblNewLabel_4_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_4_1_1.setBounds(6, 133, 117, 16);
		panel_2.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Date Debut");
		lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(260, 7, 102, 16);
		panel_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Date fin");
		lblNewLabel_3_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(260, 47, 102, 16);
		panel_2.add(lblNewLabel_3_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(240, 6, 6, 151);
		panel_2.add(panel_3);
		
		DateD = new JTextField();
		DateD.setColumns(10);
		DateD.setBounds(374, 2, 111, 26);
		panel_2.add(DateD);
		
		DateF = new JTextField();
		DateF.setColumns(10);
		DateF.setBounds(374, 42, 111, 26);
		panel_2.add(DateF);
		conexion.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nom =nomP.getText();
		String code = nce.getText();
		String Pren = Prenom.getText();
		String fin = DateD.getText();
		String debut = DateF.getText();
		String Sport=sport;
		
		Connection cn = ConnexionBd.getConnexion();
		try {
			// Création d’un statement
			st = cn.createStatement();
			// Exécution des requêtes : Insertion de données
			rs = st.executeUpdate(
					"INSERT INTO `client` VALUES ('"+nom+"','"+Pren+"','"+code+"','"+Sport+"','"+debut+"','"+fin+"')");

			if (rs==1) {
				JOptionPane.showMessageDialog(null, " client Ajouter");
				
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
