/*  Copyright 2016 Bradlee Johnson 
 *  This file is part of Panda Vault.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
**/
package org.enjekt.panda.developmentkit.internal;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.enjekt.panda.commons.api.BlackVaultDatastore;
import org.enjekt.panda.commons.models.Token;

// TODO: Auto-generated Javadoc
/**
 * The Class BlackVaultDatastoreImpl.
 */
@Singleton
public class BlackVaultDatastoreImpl implements BlackVaultDatastore{

	/**
	 * Instantiates a new black vault datastore impl.
	 */
	public BlackVaultDatastoreImpl(){}
	
	/** The data store. */
	@Inject
	private BlackVaultDevelopmentDatastore dataStore;

	/* (non-Javadoc)
	 * @see org.enjekt.panda.commons.api.BlackVaultDatastore#getPadForToken(java.lang.String)
	 */
	@Override
	public String getPadForToken(String token) {
		return dataStore.getPadForToken(token);
	}

	/* (non-Javadoc)
	 * @see org.enjekt.panda.commons.api.BlackVaultDatastore#storePadForToken(org.enjekt.panda.commons.models.Token, java.lang.String)
	 */
	@Override
	public void storePadForToken(Token token, String pad) {
		System.out.println("Store token and pad in BlackVaultDatastore: "+ token.getToken()+","+pad);
		dataStore.storePadForToken(token, pad);
	}
	
	/* (non-Javadoc)
	 * @see org.enjekt.panda.commons.api.BlackVaultDatastore#getPadsForFamilyID(java.lang.String)
	 */
	@Override
	public Map<String, String> getPadsForFamilyID(String familyId){
		return dataStore.getPadsForFamilyID(familyId);
	}

	/**
	 * Gets the data store.
	 *
	 * @return the data store
	 */
	public BlackVaultDevelopmentDatastore getDataStore() {
		return dataStore;
	}

	/**
	 * Sets the data store.
	 *
	 * @param dataStore the new data store
	 */
	public void setDataStore(BlackVaultDevelopmentDatastore dataStore) {
		this.dataStore = dataStore;
	}


}
