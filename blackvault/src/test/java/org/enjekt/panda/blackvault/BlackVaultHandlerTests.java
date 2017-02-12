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
package org.enjekt.panda.blackvault;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.enjekt.panda.blackvault.internal.beans.PadRetrieveHandler;
import org.enjekt.panda.blackvault.internal.beans.PadsForFamilyHandler;
import org.enjekt.panda.blackvault.internal.beans.TokenAddHandler;
import org.enjekt.panda.commons.api.BlackVaultDatastore;
import org.enjekt.panda.commons.models.BlackVaultDataModel;
import org.enjekt.panda.commons.models.FamilyId;
import org.enjekt.panda.commons.models.Pad;
import org.enjekt.panda.commons.models.Token;
import org.enjekt.panda.commons.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BlackVaultHandlerTests {

	@Mock
    private BlackVaultDatastore datastore;
    @InjectMocks
    private PadRetrieveHandler retrieveHandler = new PadRetrieveHandler(datastore);
    @InjectMocks
    private PadsForFamilyHandler padsForFamilyHandler = new PadsForFamilyHandler(datastore);
    @InjectMocks
    private TokenAddHandler tokenAddHandler = new TokenAddHandler(datastore);

	@Test
	public void testAddAndGetPad() {
		assertNotNull(retrieveHandler);
		assertNotNull(padsForFamilyHandler);
		assertNotNull(tokenAddHandler);
		String pan = "2221555555551234";
		Pad testPad = createPadResponse(pan);
		Token token = Utils.createToken(pan);
		when(datastore.getPadForToken(any(Token.class))).thenReturn(testPad);
		testPad.setPad("xxxx");
		Pad retrievedPad = retrieveHandler.getPadForToken(token);
		
		assertNotNull(retrievedPad);
		assertEquals("Test Pad and returned did not match",testPad.getPad(),retrievedPad.getPad());
		/*	
		Token token = Utils.createToken(pan);
		FamilyId familyId = Utils.createFamilyId(pan);
		BlackVaultDataModel bvdm = new BlackVaultDataModel(token, pad,familyId );
		tokenAddHandler.addToken(bvdm);
	
	
		Map<String,Pad> pads = padsForFamilyHandler.getPadsForFamilyID(familyId);
		assertNotNull(pads);
		
		Pad tokenPad = pads.get(token.getToken());
		assertNotNull(tokenPad);
		assertTrue(tokenPad.equals(pad));*/
	}

	private Pad createPadResponse(String pan) {
		Pad pad = Utils.createPad(pan);
		assertNotNull(pad);
		return pad;
	}

}
