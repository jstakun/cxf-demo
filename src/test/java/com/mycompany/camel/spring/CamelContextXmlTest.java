package com.mycompany.camel.spring;


import javax.ws.rs.core.Response;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class CamelContextXmlTest extends CamelSpringTestSupport {
	
	private final static String ENDPOINT_ADDRESS = "http://localhost:9090/route";

	// Mock endpoints used to consume messages from the output endpoints and then perform assertions
	@EndpointInject(uri = "mock:output")
	protected MockEndpoint outputEndpoint;
	
    
	@Test
	public void testGetSomething() throws Exception {
		
	
		
		// Call the REST endpoint
		WebClient client = WebClient.create(ENDPOINT_ADDRESS);
		client.accept("application/json");
		client.path("/restservice/getsomething/thisisatest");
		Response r = client.get();
		
		
		// Assert the values of the obect
		//assertEquals("Birmingham", a.getCity());
		//assertEquals("UK", a.getCountry());
		//assertEquals("100", a.getTSNumber());
		
	}
	
	

	@Override
	protected ClassPathXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext(
				"META-INF/spring/camel-context.xml");
	}

}