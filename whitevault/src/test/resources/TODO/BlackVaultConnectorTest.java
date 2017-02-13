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

import javax.inject.Inject;

import org.apache.camel.test.cdi.CamelCdiRunner;
import org.enjekt.panda.commons.api.BlackVaultAPI;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CamelCdiRunner.class)
public class BlackVaultConnectorTest {


	BlackVaultAPI connector;
	//@Ignore doesn't appear to work...
	@Test
	@Ignore("Black vault is sending to routes that have to be set up here.")
	public void testConnectorAdd(){
		/*System.out.println("Connector: " + connector);
		String token = "2221555555551234";
		String pad = connector.getPadForToken(token);
		assertNull(pad);	
		token="11111155551234";
		connector.addToken(token);
		String retrievedPad = connector.getPadForToken(token);
		
		assertNotNull(retrievedPad);
		System.out.println(retrievedPad);*/
	}
}
