package com.mycompany.camel.cxf;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.*;
import org.apache.cxf.message.MessageContentsList;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



public class SOAPProcessor implements Processor {


		@Override
		public void process(Exchange exchange) throws Exception {
			Message inMessage = exchange.getIn();
			
			//MessageContentsList input = (MessageContentsList) inMessage.getBody();
			//System.out.println(input.get(0).toString());
			String input = inMessage.getBody().toString();
			
            MessageFactory mf = MessageFactory.newInstance();
            SOAPMessage soapMessage = mf.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            soapEnvelope.addNamespaceDeclaration("spr", "http://cxf.camel.mycompany.com");
            SOAPBody soapBody = soapEnvelope.getBody();
            SOAPElement element = soapBody.addChildElement("input", "spr");
            element.addTextNode(input);
            soapMessage.saveChanges();
            
            final StringWriter sw = new StringWriter();

            try {
                TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(soapMessage.getSOAPPart()),
                    new StreamResult(sw));
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }

            // Now you have the XML as a String:
            System.out.println(sw.toString());
        	exchange.getOut().setBody(soapMessage);
        	
        	
        	exchange.getOut().setHeader(CxfConstants.OPERATION_NAME, "getSomethingFromSoap");
        	 
		}
        
}