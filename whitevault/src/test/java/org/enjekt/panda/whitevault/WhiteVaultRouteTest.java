package org.enjekt.panda.whitevault;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.Uri;
import org.apache.camel.test.cdi.CamelCdiRunner;
import org.enjekt.panda.whitevault.internal.routes.VaultRoutes;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(CamelCdiRunner.class)
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
