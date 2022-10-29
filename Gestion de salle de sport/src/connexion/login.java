package connexion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import menu.menu;




public class login extends JFrame implements ActionListener{
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;

	private JButton connexion;
    private JTextField id;
	private JPasswordField mdp;

    public login() {
    	setResizable(false);
    	
 
        setSize(600, 400);
        setLocationRelativeTo(null);
        userInterface();
    }
    
    private void userInterface(){
        JPanel main_pan = new JPanel(new GridLayout(1, 2));
        
        JPanel left_pan = new JPanel();
        left_pan.setBackground(new Color(0, 80, 239));
        left_pan.setLayout(null);
        
        JLabel logo = new JLabel(new ImageIcon("/Users/waelkamel/eclipse-workspace/projet java/image/computer-user-icon-27.png"));
        logo.setBounds(0, 0, 300, 400);
        logo.setText("");
        logo.setHorizontalTextPosition(JLabel.CENTER);
        logo.setVerticalTextPosition(JLabel.BOTTOM);
        logo.setForeground(Color.white);
        logo.setFont(new Font("Segoe UI", 0, 15));
        left_pan.add(logo);
        
        main_pan.add(left_pan);
        
        JPanel right_pan = new JPanel(new BorderLayout());
        right_pan.setBackground(Color.white);
        
        JPanel pan_exit = new JPanel();
        JLabel exit = new JLabel("X");
        exit.setBounds(265, 5, 30, 30);

   //        Aksi Untuk Menutup atau Keluar Dari Form Login
        
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        
        pan_exit.setLayout(null);

        exit.setPreferredSize(new Dimension(30, 30));
        exit.setHorizontalAlignment(JLabel.CENTER);
        exit.setVerticalAlignment(JLabel.CENTER);
        exit.setFont(new Font("Segoe UI", Font.BOLD, 25));
        exit.setBackground(new Color(0, 80, 239));
        exit.setForeground(Color.white);
        exit.setOpaque(true);
        pan_exit.add(exit);
        right_pan.add(pan_exit, "North");
        
        JPanel right_comp = new JPanel(new BorderLayout());
        
        JLabel title = new JLabel("Connexion");
        title.setPreferredSize(new Dimension(this.getWidth(), 70));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Segoe UI", 0, 30));
        right_comp.add(title, "North");
        
        JPanel pan = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JLabel _user = new JLabel("identifiant");
        _user.setVerticalAlignment(SwingConstants.BOTTOM);
        _user.setFont(new Font("Segoe UI", 0, 14));
        _user.setPreferredSize(new Dimension(200, 20));
        pan.add(_user);
        
         id = new JTextField();
        id.setPreferredSize(new Dimension(200, 30));
        pan.add(id);
        
        JLabel _pass = new JLabel("mot de passe");
        _pass.setFont(new Font("Segoe UI", 0, 14));
        _pass.setPreferredSize(new Dimension(200, 20));
        pan.add(_pass);
        
         mdp = new  JPasswordField();
        mdp.setPreferredSize(new Dimension(200, 30));
        pan.add(mdp);
        
        right_comp.add(pan);
        
        right_pan.add(right_comp);
        
        JPanel pan_btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pan_btn.setPreferredSize(new Dimension(this.getWidth(), 70));

        JButton connexion = new JButton("Login");
        connexion.setPreferredSize(new Dimension(120, 30));
        connexion.setFont(new Font("Segoe UI", 0, 17));
        connexion.setContentAreaFilled(false);
        connexion.setForeground(new Color(0, 80, 239));
        connexion.setBorder(BorderFactory.createLineBorder(new Color(0, 80, 239), 1, true));
        pan_btn.add(connexion);
        right_pan.add(pan_btn, "South");
        
        main_pan.add(right_pan);
        
        getContentPane().add(main_pan);
        connexion.addActionListener(this);
		setVisible(true);
    }
    
    public static void main(String[] args) {
        login obj = new login();
        obj.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String log =id.getText();
		String password = mdp.getText();
		Connection cn = ConnexionBd.getConnexion();
		try {
			// Création d’un statement
			st = cn.createStatement();
			// Exécution des requêtes : Insertion de données
			rs = st.executeQuery(
					"select * from user where id = '" +log+ "' and mdp = '" +password+ "'");

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "votre Vous êtes connectés..");
				
				setVisible(false);
				menu frame = new menu();
				frame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null,
						"Erreur d’authentification ! Veuillez re-saisir le login et le mot de passe.");
			}
		} catch (SQLException v) {
			v.printStackTrace();
		}
	}
    
}

