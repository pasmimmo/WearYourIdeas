package login;

import java.sql.*;
import login.UserBean;

public class UserDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static UserBean login(UserBean bean) {

		// preparing some objects for connection
		Statement stmt = null;

		String username = bean.getUsername();
		String password = bean.getPassword();

		String searchQuery = "select * from utente where username='" + username + "' AND password='" + password + "'";

		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Your user name is " + username);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				bean.setValido(false);
			}

			// if user exists set the isValid variable to true
			else if (more) {
				String firstName = rs.getString("nome");
				String lastName = rs.getString("cognome");
				String address = rs.getString("indirizzo");
				String codfiscale = rs.getString("codiceFiscale");
				String mail = rs.getString("email");

				System.out.println("Welcome " + firstName);
				bean.setNome(firstName);
				bean.setCognome(lastName);
				bean.setCodiceFiscale(codfiscale);
				bean.setIndirizzo(address);
				bean.setValido(true);
				bean.setMail(mail);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return bean;

	}

	public static synchronized void addUtente(UserBean bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO `ecommerce`.`utente` (`nome`, `cognome`, `username`, `password`, `indirizzo`, `email`, `codicefiscale`) VALUES (?, ?, ?, ?, ?, ?, ?)";
				/*"INSERT INTO " + TABLE_NAME
				+ " (`NOME`, `COGNOME`, `USERNAME`, `PASSWORD`, `INDIRIZZO`, `EMAIL`, `CODICEFISCALE`) VALUES (?, ?, ?, ?, ?, ?, ?)";*/

		try {
			currentCon = ConnectionManager.getConnection();
			preparedStatement = currentCon.prepareStatement(insertSQL);
			preparedStatement.setString(1, bean.getNome());
			preparedStatement.setString(2, bean.getCognome());
			preparedStatement.setString(3, bean.getUsername());
			preparedStatement.setString(4, bean.getPassword());
			preparedStatement.setString(5, bean.getIndirizzo());
			preparedStatement.setString(6, bean.getMail());
			preparedStatement.setString(7, bean.getCodfiscale());
			System.out.println("eseguo update");
			preparedStatement.executeUpdate();
			currentCon.commit();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
}
