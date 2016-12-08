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
