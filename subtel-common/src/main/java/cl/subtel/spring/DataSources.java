package cl.subtel.spring;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

import cl.subtel.entities.enviroment.Environments;

public class DataSources {

	private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL_DEV = "jdbc:oracle:thin:@172.30.10.219:1521:dreclamo";
	private static final String DB_URL_PRO = "jdbc:oracle:thin:@172.30.10.219:1521:reclamo";
	private static final String IP_MONGO_DB = "172.30.10.203";
	private static final String PORT_MONGO_DB = "27017";
	private static final String DB_MONGO_DES = "Calculos_Desa";
	private static final String BD_BDC_USER = "bdc_subtel";
	private static final String BD_BDC_PASSWORD = "bdc";
	private static final String BD_SGR_USER = "sgr_reclamos";
	private static final String BD_SGR_PASSWORD = "reclamos";
	private static final String BD_PTE_USER = "pte_subtel";
	private static final String BD_PTE_PASSWORD = "pte";
	private static final String BD_GABINETE_USER = "gabinete";
	private static final String BD_GABINETE_PASSWORD = "gabinete";
	private static final String BD_ARCGIS_USER = "arcgis";
	private static final String BD_ARCGIS_PASSWORD = "arcgis";
	public static final String SCHEMA_BDC_SUBTEL = "BDC_SUBTEL";
	public static final String SCHEMA_ARCGIS = "ARCGIS";
	public static final String SCHEMA_GABINETE = "GABINETE";
	public static final String SCHEMA_SGR_RECLAMOS = "SGR_RECLAMOS";
	
	@Bean
	public DataSource getDbcDataSource(Environments environment) {
		if (environment == Environments.Local) {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(ORACLE_DRIVER);
			dataSource.setUrl(DB_URL_DEV);
			dataSource.setUsername(BD_BDC_USER);
			dataSource.setPassword(BD_BDC_PASSWORD);
			return dataSource;
		} else if (environment == Environments.Production) {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(ORACLE_DRIVER);
			dataSource.setUrl(DB_URL_PRO);
			dataSource.setUsername(BD_BDC_USER);
			dataSource.setPassword(BD_BDC_PASSWORD);
			return dataSource;
		} else if (environment == Environments.Testing) {
			/*return new EmbeddedDatabaseBuilder()
					.setType(EmbeddedDatabaseType.H2)
					.addScript("bdc_scrip.sql")
					.build();*/
			return null;
		} else {
			return null;
		}

	}

	@Bean
	public DataSource getSgrDataSource(Environments environment) {
		if (environment == Environments.Local) {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(ORACLE_DRIVER);
			dataSource.setUrl(DB_URL_DEV);
			dataSource.setUsername(BD_SGR_USER);
			dataSource.setPassword(BD_SGR_PASSWORD);
			return dataSource;
		} else if (environment == Environments.Production) {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(ORACLE_DRIVER);
			dataSource.setUrl(DB_URL_PRO);
			dataSource.setUsername(BD_SGR_USER);
			dataSource.setPassword(BD_SGR_PASSWORD);
			return dataSource;
		} else if (environment == Environments.Testing) {
			return null;
		} else {
			return null;
		}
	}

	@Bean
	public DataSource getPteDataSource(Environments environment) {
		if (environment == Environments.Local) {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(ORACLE_DRIVER);
			dataSource.setUrl(DB_URL_DEV);
			dataSource.setUsername(BD_PTE_USER);
			dataSource.setPassword(BD_PTE_PASSWORD);
			return dataSource;
		} else if (environment == Environments.Production) {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(ORACLE_DRIVER);
			dataSource.setUrl(DB_URL_PRO);
			dataSource.setUsername(BD_PTE_USER);
			dataSource.setPassword(BD_PTE_PASSWORD);
			return dataSource;
		} else if (environment == Environments.Testing) {
			return null;
		} else {
			return null;
		}

	}

	@Bean
	public DataSource getGabineteDataSource(Environments environment) {
		if (environment == Environments.Local) {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(ORACLE_DRIVER);
			dataSource.setUrl(DB_URL_DEV);
			dataSource.setUsername(BD_GABINETE_USER);
			dataSource.setPassword(BD_GABINETE_PASSWORD);
			return dataSource;
		} else if (environment == Environments.Production) {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(ORACLE_DRIVER);
			dataSource.setUrl(DB_URL_PRO);
			dataSource.setUsername(BD_GABINETE_USER);
			dataSource.setPassword(BD_GABINETE_PASSWORD);
			return dataSource;
		} else if (environment == Environments.Testing) {
			return null;
		} else {
			return null;
		}
	}

	@Bean
	public DataSource getArcgisDataSource(Environments environment) {
		if (environment == Environments.Local) {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(ORACLE_DRIVER);
			dataSource.setUrl(DB_URL_DEV);
			dataSource.setUsername(BD_ARCGIS_USER);
			dataSource.setPassword(BD_ARCGIS_PASSWORD);
			return dataSource;
		} else if (environment == Environments.Production) {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(ORACLE_DRIVER);
			dataSource.setUrl(DB_URL_PRO);
			dataSource.setUsername(BD_ARCGIS_USER);
			dataSource.setPassword(BD_ARCGIS_PASSWORD);
			return dataSource;
		} else if (environment == Environments.Testing) {
			return null;
		} else {
			return null;
		}
	}

	@Bean
	public MongoTemplate getMongoDataSource(Environments environment) {
		String ipMongo = IP_MONGO_DB;
		int portMongoBd = Integer.parseInt(PORT_MONGO_DB);
		// String mongoDataBase = "";
		// mongoDataBase = DB_MONGO_DES;
		// mongoDataBase = DB_MONGO_PRO;
		return new MongoTemplate(new MongoClient(ipMongo, portMongoBd), DB_MONGO_DES);
	}

}
