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
package org.enjekt.panda.developmentdatstore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.apache.camel.test.cdi.CamelCdiRunner;
import org.enjekt.panda.commons.api.WhiteVaultDatastore;
import org.enjekt.panda.commons.models.FamilyId;
import org.enjekt.panda.commons.models.Pad;
import org.enjekt.panda.commons.models.Pan;
import org.enjekt.panda.commons.models.Panda;
import org.enjekt.panda.commons.models.Token;
import org.enjekt.panda.commons.models.WhiteVaultDataModel;
import org.enjekt.panda.commons.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * The Class WhiteVaultDevelopmentDataStoreTest.
 */
@RunWith(CamelCdiRunner.class)
public class WhiteVaultDevelopmentDataStoreTest {

	/** The datastore. */
	@Inject
	private WhiteVaultDatastore datastore;


	/**
	 * Gets the same token for pan.
	 *
	 * @return the same token for pan
	 */
	@Test
	public void getSameTokenForPan()
	{
		Pan pan = new Pan("2221555555551234");
		Pad pad = Utils.createPad(pan);
		assertNotNull(pad);
		Token token = Utils.createToken(pan);
		FamilyId familyId = Utils.createFamilyId(pan);
		Panda panda = Utils.createPanda(pan,pad);
		WhiteVaultDataModel wvdm = new WhiteVaultDataModel(token, panda,familyId );
		datastore.storePanda(wvdm);
		
		Token retrievedToken=datastore.getToken(panda);
		assertNotNull(token);
		assertEquals(retrievedToken.getToken(),token.getToken());
	}
	
	/**
	 * Validate same pan for token.
	 */
	@Test
	public void validateSamePandaForToken()
	{
		Pan pan = new Pan("2221555555551234");
		Pad pad = Utils.createPad(pan);
		assertNotNull(pad);
		Token token = Utils.createToken(pan);
		FamilyId familyId = Utils.createFamilyId(pan);
		Panda panda = Utils.createPanda(pan,pad);
		WhiteVaultDataModel wvdm = new WhiteVaultDataModel(token, panda,familyId );
		datastore.storePanda(wvdm);
		Panda retrievedPanda = datastore.getPanda(token);
		System.out.println("Retrieved Panda: "+retrievedPanda);
		assertNotNull(retrievedPanda);
		assertEquals(panda.getPanda(),retrievedPanda.getPanda());
	}
	

	

}
