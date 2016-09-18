package org.enjekt.panda.whitevault;

import javax.inject.Inject;

import org.apache.camel.test.cdi.CamelCdiRunner;
import org.enjekt.panda.commons.api.BlackVaultAPI;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CamelCdiRunner.class)
public class BlackVaultConnectorTest {

	@Inject
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
