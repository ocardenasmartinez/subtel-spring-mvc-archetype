package cl.subtel.utilities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cl.subtel.utilities.entities.IngresoOp;

import static cl.subtel.utilities.StringTool.appender;

public class NumeroOP {
	
	private static final Logger LOGGER = LogManager.getLogger(NumeroOP.class);

	public static Map<String, Object> getNumeroOP(Map<String, Object> request) throws Exception {
		IngresoOp in = new IngresoOp();
		in.setRemitente((String) request.get("remitente"));
		in.setRutSolicitante((String) request.get("rutSolicitante"));
		in.setTipoPersona((String) request.get("tipoPersona"));
		in.setCodigoTramite((String) request.get("codigoTramite"));
		in.setCodigoTipoDocumento((String) request.get("codigoTipoDocumento"));
		in.setCodigoMateria((String) request.get("codigoMateria"));
		in.setGlosa((String) request.get("glosa"));
		System.out.println("NumeroOP getNumeroOP: ");
		System.out.println(in);
		JsonObject temp = generarIngresoSolicLD(in);
		IngresoOp ingreso = getNumeroOP(temp, (String)request.get("url"));
		Map<String, Object> response = new HashMap<>();
		response.put("numeroIngreso", ingreso.getNumeroIngreso());
		response.put("fechaIngreso", ingreso.getFechaIngreso());
		return response;
	}

	private static JsonObject generarIngresoSolicLD(IngresoOp ingreso) throws Exception {
		JsonObject json = new JsonObject();
		JsonObject property = new JsonObject();
		property.addProperty("codigoTramite", ingreso.getCodigoTramite());
		property.addProperty("nombreTramite", "SOLICITUD RADIOCOMUNICACIONES");
		json.add("tramite", property);
		property = new JsonObject();
		property.addProperty("codigoTipoDocumento", ingreso.getCodigoTipoDocumento());
		property.addProperty("nombretipoDocumento", "SOLICITUD RADIOCOMUNICACIONES");
		json.add("tipoDocumento", property);
		property = new JsonObject();
		property.addProperty("codigoMateria", ingreso.getCodigoMateria());
		property.addProperty("nombreMateria", "SOLICITUD RADIOCOMUNICACIONES");
		json.add("materia", property);
		property = new JsonObject();
		property.addProperty("codigoDestino", "CON");
		property.addProperty("nombreDestino", "DEPTO. CONCESIONES");
		json.add("destino", property);
		json.addProperty("observaciones", ingreso.getGlosa());
		json.addProperty("rutSolicitante", ingreso.getRutSolicitante());
		property = new JsonObject();
		property.addProperty("codigoTipoPersonalidad", ingreso.getTipoPersona());
		if (ingreso.getTipoPersona().equals("N")) property.addProperty("nombreTipoPersonalidad", "Natural");
		else property.addProperty("nombreTipoPersonalidad", "Juridica");		
		json.add("tipoPersonalidad", property);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Integer fechaRecepcion = Integer.parseInt(sdf.format(date));
		json.addProperty("fechaRecepcion", fechaRecepcion);
		property = new JsonObject();
		property.addProperty("codigoServicio", "L1");
		property.addProperty("nombreServicio", "SL. RADIOCOMUNICACIONES");
		json.add("tipoServicio", property);
		if (ingreso.getTipoPersona().equals("N")) json.addProperty("remitente", ingreso.getNombreTazonSocial());  
		else json.addProperty("remitente", ingreso.getRepresentante());
		json.addProperty("usuarioCreacion", "2");
		return json;
	}

	private static IngresoOp getNumeroOP(JsonObject json, String urlIn) throws Exception {
		IngresoOp ingreso = new IngresoOp();
		System.out.println("NumeroOP getNumeroOP json:");
		System.out.println(json.toString());
		System.out.println("NumeroOP getNumeroOP urlIn:");
		System.out.println(urlIn);
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			URL url = new URL(urlIn);
			HttpPost request = new HttpPost(url.toString());
			Gson gson = new Gson();
			StringEntity params = new StringEntity(gson.toJson(json));
			request.addHeader("content-type", "application/json");
			request.setEntity(params);
			HttpResponse respuesta = httpClient.execute(request);
			HttpEntity entity = respuesta.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
				StringBuilder sb = new StringBuilder();
				int cp;
				while ((cp = reader.read()) != -1) sb.append((char) cp);
				JsonParser parser = new JsonParser();
				json = parser.parse(sb.toString()).getAsJsonObject();
				ingreso.setNumeroIngreso(json.get("numeroIngreso").getAsInt());
				ingreso.setFechaIngreso(json.get("fechaIngreso").getAsString());
				instream.close();
			}
		} catch (Exception e) {
			System.out.println(appender("Error en: ", NumeroOP.class.getName()));
			System.out.println(ExceptionUtils.getStackTrace(e));
		}
		return ingreso;
	}

}
