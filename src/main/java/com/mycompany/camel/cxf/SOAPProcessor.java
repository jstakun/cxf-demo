package com.mycompany.camel.cxf;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.*;
import java.util.List;
import java.util.Map;



public class SOAPProcessor implements Processor {


		@Override
		public void process(Exchange exchange) throws Exception {
			Message inMessage = exchange.getIn();
			
			//List<Map<String, Object>> data = (List<Map<String, Object>>)inMessage.getBody();
			
			
			//Map<String, Object> row = data.get(0);
        	//String crmId = row.get("CRMID").toString();
        	//String name = row.get("NAME").toString();
			String input = inMessage.getBody().toString();
        	
        	exchange.getOut().setBody("<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:spr='http://cxf.camel.mycompany.com'><soapenv:Header/><soapenv:Body><spr:input>" + input + "</spr:input></soapenv:Body></soapenv:Envelope>");
        	
        	exchange.getOut().setHeader(CxfConstants.OPERATION_NAME, "getSomethingFromSoap");
        	 
		}
        
}