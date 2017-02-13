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
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.enjekt.panda.commons.api.BlackVaultAPI;
import org.enjekt.panda.commons.api.WhiteVaultDatastore;
import org.enjekt.panda.commons.models.BlackVaultDataModel;
import org.enjekt.panda.commons.models.FamilyId;
import org.enjekt.panda.commons.models.FamilyPadCollection;
import org.enjekt.panda.commons.models.FamilyPandaCollection;
import org.enjekt.panda.commons.models.Pad;
import org.enjekt.panda.commons.models.Pan;
import org.enjekt.panda.commons.models.Panda;
import org.enjekt.panda.commons.models.Token;
import org.enjekt.panda.commons.models.WhiteVaultDataModel;
import org.enjekt.panda.commons.utils.Utils;
import org.enjekt.panda.whitevault.internal.beans.PanAddHandler;
import org.enjekt.panda.whitevault.internal.beans.TokenGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddPanTest {

	@Mock
    private BlackVaultAPI blackVault;
	@Mock
    private WhiteVaultDatastore datastore;
	@Mock
	private TokenGenerator tokenGenerator;
	
    @InjectMocks
	private PanAddHandler panAddHandler = new PanAddHandler();
    
    Pan pan = new Pan("2221555555551234");
    Pad pad;
    Panda panda;
    Token token;
    FamilyId familyId;
    FamilyPadCollection padc;
    FamilyPandaCollection pandac;
    
    @Before
    public void setup()
    {
    	
		pad = Utils.createPad(pan);
		familyId = Utils.createFamilyId(pan);
		token = Utils.createToken(pan);
		padc = createPadCollection(pad,token,familyId);
		panda = Utils.createPanda(pan, pad);
		pandac = createPandaCollection(panda,token,familyId);

    }
	@Test
	public void testNewTokenAndRetrieveForExistingToken() {
		assertTestReady();

		
		assertNotNull(familyId);
		assertNotNull(padc);
		
		
		when(tokenGenerator.generateToken(any(Pan.class))).thenReturn(token);
		when(blackVault.getPadsForFamilyID(any(FamilyId.class))).thenReturn(padc);
		when(datastore.getPandasForFamilyID(any(FamilyId.class))).thenReturn(pandac);
		Token returnToken = panAddHandler.addPan(pan);
		

		assertNotNull(returnToken);
		assertEquals(returnToken.getToken(),token.getToken());
	}
	
	

	private void assertTestReady() {
		assertNotNull(panAddHandler);
		assertNotNull(tokenGenerator);
		assertNotNull(blackVault);
		
	}

	private FamilyPadCollection createPadCollection(Pad pad, Token token, FamilyId familyId) {
			
		FamilyPadCollection padFamily = new FamilyPadCollection();
		padFamily.setFamilyId(familyId).addTokenAndPad(token, pad);
		return padFamily;

	}

	private FamilyPandaCollection createPandaCollection(Panda panda, Token token, FamilyId familyId) {
		
		FamilyPandaCollection pandas = new FamilyPandaCollection();
		pandas.setFamilyId(familyId).addTokenAndPanda(token,panda);
		return pandas;

	}
}
