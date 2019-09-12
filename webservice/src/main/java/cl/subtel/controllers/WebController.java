package cl.subtel.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.subtel.entities.response.ServiceResponse;
import cl.subtel.business.Business;
import cl.subtel.request.entities.Request;
import cl.subtel.request.entities.Response;

@RestController
@RequestMapping("/service")
public class WebController {

	private static final Logger LOGGER = LogManager.getLogger(WebController.class);

	@Autowired
	Business business;

	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceResponse<String> getMethod(@RequestParam(value = "message") String request) {
		ServiceResponse<String> response = new ServiceResponse<>();
		try {
			response.setMessage("OK");
			response.setData(business.sayHello(request));
		} catch (Exception e) {
			response.setMessage("NOK");
			response.setError("Hubo un error");
			LOGGER.error(ExceptionUtils.getStackTrace(e));
		}
		return response;
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceResponse<Response> postMethod(@RequestBody Request request) {
		ServiceResponse<Response> response = new ServiceResponse<>();
		Response out = new Response();
		try {
			out.setMessage(business.sayHello(request.getMessage()));
			List<String> list = new ArrayList<>();
			list.add("1");
			list.add("2");
			list.add("3");
			out.setListMessage(list);
			response.setMessage("OK");
			response.setData(out);
		} catch (Exception e) {
			response.setMessage("NOK");
			response.setError("Hubo un error");
			LOGGER.error(ExceptionUtils.getStackTrace(e));
		}
		return response;
	}

}
