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
package org.enjekt.panda.whitevault;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.Uri;
import org.apache.camel.test.cdi.CamelCdiRunner;
import org.enjekt.panda.whitevault.internal.routes.VaultRoutes;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

//TODO This won't run with the CXF route in the class.
@Ignore
//@RunWith(CamelCdiRunner.class)
public class WhiteVaultRouteTest {

	    @Inject
	    @Uri(VaultRoutes.GET_PAN)
	    private ProducerTemplate getPan;
	    
	    @Inject
	    @Uri(VaultRoutes.ADD_PAN)
	    private ProducerTemplate addPan;
	    
/*	    
		@Test
		public void verifyInvalidPanForToken()
		{
			String pan = (String) getPan.requestBody("2221555555551234");
			System.out.println(pan);
			assertEquals(pan,"INVALID");
			
		}*/
		
		@Test
		public void verifyValidAddAndRetrieve(){
			String testPan="2221555555551234";
			String token = (String) addPan.requestBody(testPan);
			
			System.out.println("Token in test: "+ token);
			assertNotNull(token);
			
			String retrievedPan = (String) getPan.requestBody(token);
			System.out.println("In test got pan for token: "+token+","+retrievedPan);
			assertEquals(testPan,retrievedPan);
					
			
		}

	}
