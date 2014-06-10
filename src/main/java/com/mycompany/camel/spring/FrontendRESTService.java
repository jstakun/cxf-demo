package com.mycompany.camel.spring;

import javax.ws.rs.*;


@Path("/frontendrestservice/")
public class FrontendRESTService {
	
	public FrontendRESTService() {
		
	}
	
	@GET
    @Path("/getsomething/")
    @Produces("application/json")
    public String getSomething() {
        return null;
    }

}
