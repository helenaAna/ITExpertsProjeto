package com.itexperts.projetofinal.model.exception;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 
 public class ErroPadrao implements Serializable{
private static final long serialVersionUID = 1L;
	
	private Instant timeStamp;
	private Integer status;
	private String error;
	private String message;
	private List<String> messages;
	private String path;
	
	public ErroPadrao() {
	}

	public ErroPadrao(Instant timeStamp, Integer status, String error, String message, String path) {
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
}
