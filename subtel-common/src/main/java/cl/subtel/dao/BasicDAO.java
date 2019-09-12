package cl.subtel.dao;

import javax.sql.DataSource;

import org.springframework.data.mongodb.core.MongoTemplate;

public interface BasicDAO {
	
	public void setDbcDataSource(DataSource dataSource);
	public void setSrgDataSource(DataSource dataSource);
	public void setPteDataSource(DataSource dataSource);
	public void setGabineteDataSource(DataSource dataSource);
	public void setArcgisDataSource(DataSource dataSource);
	public void setMongoDataSource(MongoTemplate mongoDb);

}
