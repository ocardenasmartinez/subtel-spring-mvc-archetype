package cl.subtel.dao;

import cl.subtel.dao.BasicDAO;

public interface DAO extends BasicDAO {

	public String sayHelloOracle(String in) throws Exception;
	public String sayHelloMongo(String in) throws Exception;

}
