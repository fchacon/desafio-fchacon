package com.desafio.fchacon.util;

import org.apache.log4j.Logger;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
public class LogFactory {

	public static final String DEFAULT_LOGGER = "LOGGER";
	public static final String DEFAULT_TRACKER = "TRACKER";

	private static LogFactory factory;
	private Logger logger;
	private Logger tracker;


	public static Logger getLogger(){
		if(factory == null ){
			factory = new LogFactory();
			factory.init();
		}
		return  factory.logger;
	}
	
	public static Logger getTracker(){
		if(factory == null ){
			factory = new LogFactory();
			factory.init();
		}
		return  factory.tracker;
	}	

	private void init(){
		System.out.println("Iniciando el logger...");
		logger = Logger.getLogger(DEFAULT_LOGGER);
		tracker = Logger.getLogger(DEFAULT_TRACKER);
	}

}
