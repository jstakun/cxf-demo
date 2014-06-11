package com.mycompany.camel.spring;

import javax.ws.rs.*;


@Path("/restservice/")
public class BackendRESTService {
	
	public BackendRESTService() {
		
	}
	
	@GET
    @Path("/getsomething/{input}/")
    @Produces("application/json")
    public String getSomething(@PathParam("input") String input) {
		System.out.println("Called the backend REST Service");
        return input + " something added by the backend REST service";
    }

}
