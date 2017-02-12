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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.enjekt.panda.blackvault.internal.beans.PadRetrieveHandler;
import org.enjekt.panda.blackvault.internal.beans.PadsForFamilyHandler;
import org.enjekt.panda.blackvault.internal.beans.TokenAddHandler;
import org.enjekt.panda.commons.api.BlackVaultDatastore;
import org.enjekt.panda.commons.models.BlackVaultDataModel;
import org.enjekt.panda.commons.models.FamilyId;
import org.enjekt.panda.commons.models.FamilyPadCollection;
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
public class TestPadsForFamilyIdHandler {

	@Mock
    private BlackVaultDatastore datastore;

    @InjectMocks
    private PadsForFamilyHandler padsForFamilyHandler = new PadsForFamilyHandler(datastore);
 

	@Test
	public void testAddAndGetPad() {

		assertNotNull(padsForFamilyHandler);
		String pan = "2221555555551234";
		FamilyId familyId = Utils.createFamilyId(pan);
		

		when(datastore.getPadsForFamilyID(any(FamilyId.class))).thenReturn(createResponse(pan,familyId));
		FamilyPadCollection familyPadCollection = padsForFamilyHandler.getPadsForFamilyID(familyId);
		assertNotNull(familyPadCollection);
		
		assertTrue(familyPadCollection.getFamilyId().getId().equals("2221551234"));
		assertEquals(familyPadCollection.getTokenToPadMap().size(),1);
		
	}
	
	private FamilyPadCollection createResponse(String pan, FamilyId familyId){
		
		FamilyPadCollection padFamily = new FamilyPadCollection();
		Pad pad = Utils.createPad(pan);
		Token token = Utils.createToken(pan);
		padFamily.setFamilyId(familyId).addTokenAndPad(token, pad);
		return padFamily;

	}

	

}
