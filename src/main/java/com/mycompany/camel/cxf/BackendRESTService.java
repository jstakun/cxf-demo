package com.mycompany.camel.cxf;

import javax.ws.rs.*;


@Path("/restservice/")
public class BackendRESTService {
	
	public BackendRESTService() {
		
	}
	
	@GET
    @Path("/getsomething/{input}/")
    @Produces("application/json")
    public String getSomething(@PathParam("input") String input) {
		
		String output = "Backend REST service response"; 
		System.out.println("Called the backend REST Service and returned: " + output);
		return output; 
    }

}
