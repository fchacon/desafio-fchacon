package com.desafio.fchacon.ws.wrapper;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ErrorWrapper implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -221950532213654658L;
	private Long code;
	private String messageKey;
	private String message;
	
	public ErrorWrapper() {}
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}
}
