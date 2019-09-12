package cl.subtel.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cl.subtel.business.Business;
import cl.subtel.business.BusinessImpl;
import cl.subtel.dao.DAO;
import cl.subtel.dao.DAOImpl;
import cl.subtel.entities.enviroment.Environments;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "cl.subtel.controllers")
public class ApplicationConfiguration extends DataSources {

	@Bean
	public DAO getDao() throws Exception {
		DAO dao = new DAOImpl();
		dao.setDbcDataSource(getDbcDataSource(Environments.Local));
		dao.setSrgDataSource(getSgrDataSource(Environments.Local));
		dao.setPteDataSource(getPteDataSource(Environments.Local));
		dao.setGabineteDataSource(getGabineteDataSource(Environments.Local));
		dao.setArcgisDataSource(getArcgisDataSource(Environments.Local));
		dao.setMongoDataSource(getMongoDataSource(Environments.Local));
		return dao;
	}

	@Bean()
	public Business getBusiness() throws Exception {
		Business business = new BusinessImpl();
		business.setDao(getDao());
		return business;
	}
	
}