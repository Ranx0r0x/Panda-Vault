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
package org.enjekt.panda.developmentdatstore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.inject.Inject;

import org.apache.camel.test.cdi.CamelCdiRunner;
import org.enjekt.panda.commons.api.BlackVaultDatastore;
import org.enjekt.panda.commons.models.Token;
import org.enjekt.panda.commons.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;


// TODO: Auto-generated Javadoc
/**
 * The Class BlackVaultDevelopmentDatastoreTest.
 */
@RunWith(CamelCdiRunner.class)
public class BlackVaultDevelopmentDatastoreTest {

	/** The datastore. */
	@Inject
	private BlackVaultDatastore datastore;
	
	/**
	 * Gets the same pad for token.
	 *
	 * @return the same pad for token
	 */
	@Test
	public void getSamePadForToken()
	{

		String pad = datastore.getPadForToken("2221555555551234");
		assertNull(pad);	
		Token token = new Token();
		token.setToken("11111155551234");
		token.setFamilyId("111111234");
		pad = Utils.generatePad().toString();
		datastore.storePadForToken(token, pad);
		String retrievedPad = datastore.getPadForToken(token.getToken());
		
		assertNotNull(retrievedPad);
		assertEquals(pad,retrievedPad);
	}
	

}
