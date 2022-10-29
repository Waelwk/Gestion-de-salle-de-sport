package menu;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Interface extends JFrame implements ActionListener {
	static JTextArea afficheur;

	public Interface() {
		setResizable(false);
		setTitle("Application");
		setSize(750, 400);
		Container c = getContentPane();
		c.setLayout(new GridLayout(4, 1));

		setMenuBar(new menu()); //ajouter tous les champs dans un bare
		setVisible(true);
	}

	private void setMenuBar(menu menu) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Interface();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
