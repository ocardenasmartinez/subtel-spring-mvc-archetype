package cl.subtel.business;

import cl.subtel.dao.DAO;

public interface Business {

	public void setDao(DAO dao);

	public String sayHello(String in) throws Exception;

}
