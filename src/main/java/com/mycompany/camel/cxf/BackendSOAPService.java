/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mycompany.camel.cxf;

//import com.tmg.fuse.poc.account.InputAccount;
import javax.xml.bind.JAXBElement;
import javax.xml.ws.Holder;



/**
 * This is the implementation of the real web service
 *
 * @version 
 */
public class BackendSOAPService implements BackendSOAPServicePortType {


	@Override
	public String getSomethingFromSoap(String input) {
		System.out.println("Called the SOAP service");
		String result = input + " plus somethinig added by the SOAP service";
		return result;
	}

	
}
