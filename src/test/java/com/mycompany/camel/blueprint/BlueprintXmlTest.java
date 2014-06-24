package com.mycompany.camel.blueprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

public class BlueprintXmlTest extends CamelBlueprintTestSupport {

	private final static String ENDPOINT_ADDRESS = "http://localhost:9090/route";

	// Mock endpoints used to consume messages from the output endpoints and then perform assertions
	@EndpointInject(uri = "mock:output")
	protected MockEndpoint outputEndpoint;
	
	

	@Override
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	@Test
	public void testBackendSOAPService() throws Exception {
				
		// Call the REST endpoint
		WebClient client = WebClient.create(ENDPOINT_ADDRESS);
		client.accept("application/json");
		client.path("/restservice/getsomething/callSoapService");
		Response r = client.get();
		String output = r.readEntity(String.class);
		
		assertEquals("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><output xmlns=\"http://cxf.camel.mycompany.com\">SOAP service response</output></soap:Body></soap:Envelope>", output);
		
		client.replacePath("/restservice/getsomething/callRestService");
		r = client.get();
		output = r.readEntity(String.class);
		
		assertEquals("Backend REST service response", output);
	}


	@Override
	protected String getBlueprintDescriptor() {
		return "OSGI-INF/blueprint/blueprint.xml";
	}
	

}
