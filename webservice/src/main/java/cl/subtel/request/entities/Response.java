package cl.subtel.request.entities;

import java.util.List;

public class Response {

	private String message;
	private List<String> listMessage;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getListMessage() {
		return listMessage;
	}

	public void setListMessage(List<String> listMessage) {
		this.listMessage = listMessage;
	}

}
