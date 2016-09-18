package org.enjekt.panda.whitevault;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import javax.inject.Inject;

import org.apache.camel.test.cdi.CamelCdiRunner;
import org.enjekt.panda.commons.models.Token;
import org.enjekt.panda.commons.utils.Utils;
import org.enjekt.panda.whitevault.internal.beans.TokenGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CamelCdiRunner.class)
public class TokenGeneratorTest {

	@Inject
	TokenGenerator tokenGenerator;

	@Test
	public void tokenGeneratorTest() {
		String pan = "2221555555551234";
		//System.out.println("Pan is valid: "+ Utils.luhnVerify(pan));
		for(int i=0;i<1000;i++)
		{
			Token token = tokenGenerator.generateToken(pan);
/*			System.out.println("Original: " + pan);
			System.out.println("Token:    " + token);*/
			assertFalse(Utils.luhnVerify(token));
			assertEquals(token.getFamilyId(),"2221551234");
		}
			
	}

}
