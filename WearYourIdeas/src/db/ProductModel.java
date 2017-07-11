package db;

import java.sql.SQLException;
import java.util.Collection;

public interface ProductModel {
	public void doSave(BeanProdotto product) throws SQLException;

	public boolean doDelete(int code) throws SQLException;

	public BeanProdotto doRetrieveByKey(int code) throws SQLException;
	
	public Collection<BeanProdotto> doRetrieveAll(String order) throws SQLException;
}
