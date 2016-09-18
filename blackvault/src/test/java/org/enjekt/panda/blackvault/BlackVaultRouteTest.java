/*  Copyright Bradlee Johnson 2016
 *  This file is part of Panda Vault.

    Panda Vault is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Panda Vault is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero Public License for more details.

    You should have received a copy of the GNU Affero Public License
    along with Panda Vault.  If not, see <http://www.gnu.org/licenses/>.
 */
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
