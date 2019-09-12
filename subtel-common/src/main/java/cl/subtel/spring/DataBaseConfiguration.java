package cl.subtel.spring;

import javax.sql.DataSource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataBaseConfiguration {
	
	JdbcTemplate jdbcTemplateObject;
	public DataSource bdcDataSource;
	public DataSource sgrDataSource;
	public DataSource pteDataSource;
	public DataSource gabineteDataSource;
	public DataSource arcgisDataSource;
	public MongoTemplate mongoDb;

	public void setDbcDataSource(DataSource dataSource) {
		this.bdcDataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void setSrgDataSource(DataSource dataSource) {
		this.sgrDataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void setPteDataSource(DataSource dataSource) {
		this.pteDataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void setGabineteDataSource(DataSource dataSource) {
		this.gabineteDataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void setArcgisDataSource(DataSource dataSource) {
		this.arcgisDataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void setMongoDataSource(MongoTemplate mongoDb) {
		this.mongoDb = mongoDb;
	}
		
}
