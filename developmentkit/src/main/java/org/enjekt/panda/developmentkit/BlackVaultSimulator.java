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
package org.enjekt.panda.developmentkit;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.enjekt.panda.commons.api.BlackVaultAPI;
import org.enjekt.panda.commons.models.BlackVaultDataModel;
import org.enjekt.panda.commons.models.FamilyId;
import org.enjekt.panda.commons.models.Pad;
import org.enjekt.panda.commons.models.Token;

/**
 * The Class BlackVaultConnectorImpl.
 */
@Singleton
public class BlackVaultSimulator implements BlackVaultAPI {
	
	@Inject
	private BlackVaultDevelopmentDatastore dataStore;
	
	public BlackVaultSimulator() {}
	public BlackVaultSimulator(BlackVaultDevelopmentDatastore blackVaultDevelopmentDatastore) {
		this.dataStore=blackVaultDevelopmentDatastore;
	}

	public BlackVaultDevelopmentDatastore getDataStore() {
		return dataStore;
	}


	@Override
	public Pad getPadForToken(Token token) {
		return dataStore.getPadForToken(token);
	}


	@Override
	public void addToken(BlackVaultDataModel bvdm) {
		dataStore.store(bvdm);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<String,Pad> getPadsForFamilyID(FamilyId familyId) {
		return dataStore.getPadsForFamilyID(familyId);
	}


	public void setDataStore(BlackVaultDevelopmentDatastore dataStore) {
		this.dataStore = dataStore;
	}




}
