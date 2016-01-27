package com.mycompany.camel.cxf;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class OtherProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message inMessage = exchange.getIn();
		
		String input = inMessage.getBody().toString();
		
		exchange.getOut().setBody("Unrecognized service " + input);
	}

}
