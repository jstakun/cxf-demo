package com.mycompany.camel.blueprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.camel.EndpointInject;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

public class BlueprintXmlTest extends CamelBlueprintTestSupport {

	private final static String ENDPOINT_ADDRESS = "http://localhost:9090/route";

	// Mock endpoints used to consume messages from the output endpoints and then perform assertions
	@EndpointInject(uri = "mock:output")
	protected MockEndpoint outputEndpoint;

	@Test
	public void testCamelRoute() throws Exception {
		
		// Call the REST endpoint
		WebClient client = WebClient.create(ENDPOINT_ADDRESS);
		client.accept("application/json");
		client.path("/restservice/getsomething/thisisatest");
		Response r = client.get();
		String output = r.readEntity(String.class);
		System.out.println(output);
		
		// Assert the values of the obect
		assertEquals("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><output xmlns=\"http://cxf.camel.mycompany.com\">thisisatest something added by the backend REST service plus somethinig added by the SOAP service</output></soap:Body></soap:Envelope>", output);
		
	}

	@Override
	protected String getBlueprintDescriptor() {
		return "OSGI-INF/blueprint/blueprint.xml";
	}
	

}
