package com.desafio.fchacon.bc;

import org.apache.log4j.Logger;

import com.desafio.fchacon.util.LogFactory;

public class BaseBC {
	protected Logger log;
	protected Logger track;

	protected BaseBC() {
		this.log = LogFactory.getLogger();
		this.track = LogFactory.getTracker();
	}
}
