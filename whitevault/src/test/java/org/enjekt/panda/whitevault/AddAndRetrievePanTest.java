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

import javax.inject.Inject;

import org.apache.camel.test.cdi.CamelCdiRunner;
import org.enjekt.panda.whitevault.internal.beans.PanAddHandler;
import org.enjekt.panda.whitevault.internal.beans.PanRetrieveHandler;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CamelCdiRunner.class)
public class AddAndRetrievePanTest {

	@Inject
	private PanAddHandler panAddHandler;
	
	@Inject
	private PanRetrieveHandler panRetrieveHandler;

	@Test
	public void testNewTokenAndRetrieveForExistingToken() {
		String pan = "12345678901234567";
		String token = panAddHandler.addPan(pan);
		String retrievedPan = panRetrieveHandler.getPan(token);
		assertEquals(pan,retrievedPan);
		String verifyToken = panAddHandler.addPan(pan);
		assertEquals(token,verifyToken);
	}
	

}
