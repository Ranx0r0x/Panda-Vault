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

import static org.junit.Assert.*;

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
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TokenAddHandlerTest {

	@Mock
    private BlackVaultDatastore datastore;
    @InjectMocks
    private TokenAddHandler tokenAddHandler = new TokenAddHandler(datastore);

	@Test
	public void testAddToken() {
	
		assertNotNull(tokenAddHandler);
		String pan = "2221555555551234";
		Pad pad = Utils.createPad(pan);
		Token token = Utils.createToken(pan);
		FamilyId familyId = Utils.createFamilyId(pan);
		BlackVaultDataModel bvdm = new BlackVaultDataModel(token, pad,familyId );
		tokenAddHandler.addToken(bvdm);
		verify(datastore).store(bvdm);


	}


}
