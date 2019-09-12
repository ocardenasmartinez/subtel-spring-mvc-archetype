package cl.subtel.business;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import cl.subtel.dao.DAO;

public class BusinessImpl implements Business {

	private DAO dao;
	private static final Logger LOGGER = LogManager.getLogger(BusinessImpl.class);

	@Override
	public String sayHello(String in) throws Exception {
		String out = "";
		try {
			out = dao.sayHelloOracle(in);
		} catch (Exception e) {
			LOGGER.error(e);
			throw e;
		}
		return out;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

}
