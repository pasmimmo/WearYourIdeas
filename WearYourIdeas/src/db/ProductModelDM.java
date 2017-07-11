package db;
//NON USATO
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class ProductModelDM implements ProductModel {

	private static final String TABLE_NAME = "prodotti";

	@Override
	public synchronized void doSave(BeanProdotto product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ProductModelDM.TABLE_NAME
				+ " (IDPRODOTTI, NOME, DESCRIZIONE, TIPO, QUANTITA, PREZZO, TAGLIA, COLORE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			int ifprof = (doRetrieveAll(null).size())+1;
			System.out.println("\n\n\n\n\n ciaoooooooo\n"+ifprof);
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, product.getIdprod());
			preparedStatement.setString(2, product.getNome());
			preparedStatement.setString(3, product.getDescrizione());
			preparedStatement.setString(4, product.getTipo());
			preparedStatement.setInt(5, product.getQuantita());
			preparedStatement.setFloat(6, product.getPrezzo());
			preparedStatement.setString(7, product.getTaglia());
			preparedStatement.setString(8, product.getColore());
			
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	@Override
	public synchronized BeanProdotto doRetrieveByKey(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		BeanProdotto bean = new BeanProdotto();

		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME + " WHERE IDPRODOTTI = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setIdprod(rs.getInt("IDPRODOTTI"));
				bean.setNome(rs.getString("NOME"));
				bean.setDescrizione(rs.getString("DESCRIZIONE"));
				bean.setPrezzo(rs.getInt("PREZZO"));
				bean.setQuantita(rs.getInt("QUANTITA"));
				bean.setColore(rs.getString("COLORE"));
				bean.setTipo(rs.getString("TIPO"));
				bean.setTaglia(rs.getString("TAGLIA"));
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}

	@Override
	public synchronized boolean doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ProductModelDM.TABLE_NAME + " WHERE IDPRODOTTI = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}

	@Override
	public synchronized Collection<BeanProdotto> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<BeanProdotto> products = new LinkedList<BeanProdotto>();

		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				BeanProdotto bean = new BeanProdotto();
				bean.setIdprod(rs.getInt("IDPRODOTTI"));
				bean.setNome(rs.getString("NOME"));
				bean.setDescrizione(rs.getString("DESCRIZIONE"));
				bean.setPrezzo(rs.getFloat("PREZZO"));
				bean.setQuantita(rs.getInt("QUANTITA"));
				bean.setColore(rs.getString("COLORE"));
				bean.setTipo(rs.getString("TIPO"));
				bean.setTaglia(rs.getString("TAGLIA"));
				products.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}

}