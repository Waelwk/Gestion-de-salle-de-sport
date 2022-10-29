package ListePersonne;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connexion.ConnexionBd;
import connexion.login;
import menu.menu;
import net.proteanit.sql.DbUtils;

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
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class ListePersonne extends JFrame {

	private JPanel contentPane;
	static JLabel zoneT;
	private JTable table;
	
	private JTextField nce;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ListePersonne frame = new ListePersonne();
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
	public ListePersonne() {
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
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				menu obj = new menu();
		        obj.setVisible(true);

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
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 534, 148);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int index = table.getSelectedRow();
				nce.setText(model.getValueAt(index, 2).toString());
				
			}
		});
		table.setForeground(Color.BLACK);
		table.setBounds(10, 126, 510, 173);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null,null, null, null }, { null, null, null,null, null, null } },
				new String[] {  "NOM", "PRENOM","NCE","SPORT", "DATED", "DATEF" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false,false,false,false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("supprimer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection cn = ConnexionBd.getConnexion();
				Statement st = null;
				if (nce.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Saisir nce de client a supprimé");
				}
				try {
					String idc = nce.getText();
					st = cn.createStatement();
					st.executeUpdate("DELETE FROM `client` WHERE nce="+idc);
					JOptionPane.showMessageDialog(null, "client supprimé aves succeés");
					getClients();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(427, 290, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("liste d'abonment:");
		lblNewLabel_2.setFont(new Font("Oriya Sangam MN", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(10, 113, 117, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NCE");
		lblNewLabel_3.setBounds(177, 295, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		nce = new JTextField();
		nce.setEnabled(false);
		nce.setEditable(false);
		nce.setBounds(245, 290, 130, 26);
		contentPane.add(nce);
		nce.setColumns(10);
		getClients();
	   // System.out.println(getClients().toString());
	}
	 
	

		
	public void getClients() {
		Connection cn = ConnexionBd.getConnexion();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = cn.createStatement();
			rs = st.executeQuery("select * from client");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
