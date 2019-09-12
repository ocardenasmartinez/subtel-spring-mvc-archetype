package cl.subtel.dao;

import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import cl.subtel.spring.DataBaseConfiguration;

public class DAOImpl extends DataBaseConfiguration implements DAO {

	private static final String PKG_HELLO_WORLD = "PKG_HELLO_WORLD";
	private static final String PRC_HELLO_WORLD_ARCHETYPE = "PRC_HELLO_WORLD_ARCHETYPE";
	private static final String SCHEMA = "BDC_SUBTEL";
	private static final Logger LOGGER = LogManager.getLogger(DAOImpl.class);
		
	@Override
	public String sayHelloOracle(String request) throws Exception {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(this.sgrDataSource)
				.withSchemaName(SCHEMA)
				.withCatalogName(PKG_HELLO_WORLD)
				.withProcedureName(PRC_HELLO_WORLD_ARCHETYPE);
		String response = "";
		SqlParameterSource in = new MapSqlParameterSource().addValue("PARAMETER_IN", request);
		try {
			Map<String, Object> out = jdbcCall.execute(in);
			LOGGER.info("Respuesta del procedimiento " + PRC_HELLO_WORLD_ARCHETYPE);
			LOGGER.info(out);
			response = (String) out.get("PARAMETER_OUT");
		} catch (Exception e) {
			LOGGER.error(e);
			throw e;
		}
		return response;
	}

	@Override
	public String sayHelloMongo(String in) throws Exception {		
		Query query = new Query(Criteria.where("id").is(1));
		Iterator<String> iterator = mongoDb.find(query, String.class, "hello_world").iterator();
		while(iterator.hasNext()) System.out.println(iterator.next());
		return "";
	}

}
