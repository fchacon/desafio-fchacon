package com.desafio.fchacon.ws;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.apache.log4j.Logger;

import com.desafio.fchacon.util.LogFactory;

public class BaseWS {

	@Context
	private HttpServletRequest httprequest;
	@Context
	private HttpServletResponse httpresponse;

	protected Logger log;
	protected Logger track;

	protected BaseWS(){
		log = LogFactory.getLogger();
		track = LogFactory.getTracker();
	}
}