package com.mycompany.camel.cxf;

import javax.ws.rs.*;


@Path("/restservice/")
public class FrontendRESTService {
	
	public FrontendRESTService() {
		
	}
	
	@GET
    @Path("/getsomething/{input}/")
    @Produces("application/json")
    public String getSomething(@PathParam("input") String input) {
		System.out.println("Called the frontend Service");
        return "";
    }

}
