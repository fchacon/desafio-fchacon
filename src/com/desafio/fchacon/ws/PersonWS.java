package com.desafio.fchacon.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.desafio.fchacon.bc.PersonBC;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/person")
public class PersonWS extends BaseWS {
	
	@GET
	@Path("/getAge")
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Object getByCorrelative(
			@QueryParam("run") String run,
			@QueryParam("fullName") String fullName,
			@QueryParam("birthDate") String birthDate,
			@QueryParam("gender") String gender) {
		
		return PersonBC.getAge(run, fullName, birthDate, gender);
	}
}
