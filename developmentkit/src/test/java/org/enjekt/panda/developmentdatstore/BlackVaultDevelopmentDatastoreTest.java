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


@RunWith(CamelCdiRunner.class)
public class BlackVaultDevelopmentDatastoreTest {

	@Inject
	private BlackVaultDatastore datastore;
	
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
