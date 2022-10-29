package loder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import connexion.login;
import javax.swing.JTextField;


public class loder extends JFrame {
	

	private JPanel contentPane;
	private JProgressBar progressBar;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		loder myLoader = new loder();
		myLoader.setVisible(true);
		try {
			for (int i = 0; i <= 100; i++) {
				Thread.sleep(40);
				myLoader.progressBar.setValue(i);
				myLoader.lblNewLabel_1.setText(Integer.toString(i) + "%");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		new login().setVisible(true);
		myLoader.dispose();

	}

	/**
	 * Create the frame.
	 */
	public loder() {
		setResizable(false);
		
		
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 400);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(240, 255, 255));
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setBounds(0, 361, 650, 11);
		progressBar.setForeground(new Color(30, 144, 255));
		contentPane.add(progressBar);

		lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setBounds(222, 317, 58, 55);
		lblNewLabel_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2_1 = new JLabel("Gestion ");
		lblNewLabel_2_1.setBackground(Color.PINK);
		lblNewLabel_2_1.setBounds(120, 13, 144, 48);
		lblNewLabel_2_1.setForeground(Color.PINK);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3 = new JLabel("De");
		lblNewLabel_3.setBounds(131, 45, 61, 16);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Snell Roundhand", Font.ITALIC, 15));
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Salle de sport ");
		lblNewLabel_4.setBounds(140, 54, 331, 35);
		lblNewLabel_4.setForeground(Color.PINK);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 31));
		contentPane.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/waelkamel/eclipse-workspace/projet java/image/entrainement (3).png"));
		lblNewLabel.setBounds(15, 153, 128, 128);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("/Users/waelkamel/eclipse-workspace/projet java/image/entrainement (1).png"));
		lblNewLabel_5.setBounds(166, 153, 136, 128);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("New label");
		lblNewLabel_5_1.setIcon(new ImageIcon("/Users/waelkamel/eclipse-workspace/projet java/image/entrainement.png"));
		lblNewLabel_5_1.setBounds(319, 153, 136, 128);
		contentPane.add(lblNewLabel_5_1);
	}
}