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

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.camel.test.cdi.CamelCdiRunner;
import org.enjekt.panda.commons.api.BlackVaultDatastore;
import org.enjekt.panda.commons.models.Pan;
import org.enjekt.panda.commons.models.Token;
import org.enjekt.panda.whitevault.internal.beans.PanAddHandler;
import org.enjekt.panda.whitevault.internal.beans.PanRetrieveHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class AddAndRetrievePanTest {

	@Mock
    private BlackVaultDatastore datastore;
    @InjectMocks
	private PanAddHandler panAddHandler = new PanAddHandler();
    @InjectMocks
	private PanRetrieveHandler panRetrieveHandler = new PanRetrieveHandler();

	@Test
	public void testNewTokenAndRetrieveForExistingToken() {
		Pan pan = new Pan("12345678901234567");
		Token token = panAddHandler.addPan(pan);
		assertNotNull(token);
		Pan retrievedPan = panRetrieveHandler.getPan(token);
		assertNotNull(retrievedPan);
		assertNotNull(retrievedPan.getPan());
		assertEquals(pan.getPan(),retrievedPan.getPan());
		Token verifyToken = panAddHandler.addPan(pan);
		System.out.println("VERIFY TOKEN: "+ verifyToken.toString());
		assertNotNull(verifyToken);
		assertTrue(token.equals(verifyToken));
	}
	

}
