package com.desafio.fchacon.ws.wrapper;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ResponseWrapper implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9161357629428948235L;
	private String status;
	private Object data;
	private ErrorWrapper error;
	
	public ResponseWrapper() {}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.status = "OK";
		this.data = data;
	}

	public ErrorWrapper getError() {
		return error;
	}

	public void setError(ErrorWrapper error) {
		this.status = "NOK";
		this.error = error;
	}
	
	public void setError(String errorMsg) {
		this.status = "NOK";
		this.error = new ErrorWrapper();
		this.error.setMessage(errorMsg);
	}
}
