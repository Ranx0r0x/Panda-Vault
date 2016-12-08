/*  Copyright 2016 Bradlee Johnson 
 *  This file is part of Panda Vault.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
**/
package org.enjekt.panda.blackvault;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.inject.Inject;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.Uri;
import org.apache.camel.test.cdi.CamelCdiRunner;
import org.enjekt.panda.blackvault.internal.routes.VaultRoutes;
import org.enjekt.panda.commons.models.Token;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CamelCdiRunner.class)
public class BlackVaultRouteTest {

    @Inject
    @Uri(VaultRoutes.GET_PAD)
    private ProducerTemplate getPad;
    
    @Inject
    @Uri(VaultRoutes.ADD_TOKEN)
    private ProducerTemplate addToken;
    
    

	@Test
	public void testAddAndGetPad() {
		assertNotNull(addToken);
		assertNotNull(getPad);
		String pad = (String) getPad.requestBody("2221555555551234");
		assertNull(pad);
		Token token = new Token();
		token.setToken("11111155551234");
		token.setFamilyId("11111234");
		
		addToken.sendBody(token);
		String retrievedPad =  (String) getPad.requestBody(token.getToken());

		assertNotNull(retrievedPad);
		System.out.println(retrievedPad);
	}

}
