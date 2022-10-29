
	package connexion;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class ConnexionBd {

		public final static String url = "jdbc:mysql://localhost:8889/Gesstionsalle";
		public final static String login = "root";
		public final static String passwd = "root";

		public static Connection getConnexion() {
			Connection cn = null;
			try {
				// Chargement du driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				// Récupération de la connexion
				cn = DriverManager.getConnection(url, login, passwd);

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return cn;

		     }

	}


