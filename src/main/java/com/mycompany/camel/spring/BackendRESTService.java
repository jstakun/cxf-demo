package com.mycompany.camel.spring;

import javax.ws.rs.*;


@Path("/backendrestservice/")
public class BackendRESTService {
	
	public BackendRESTService() {
		
	}
	
	@GET
    @Path("/getsomething/")
    @Produces("application/json")
    public String getSomething() {
        return "something from the backend REST service";
    }

}
