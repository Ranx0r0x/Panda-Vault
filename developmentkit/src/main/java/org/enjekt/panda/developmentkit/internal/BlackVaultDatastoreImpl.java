/*  Copyright Bradlee Johnson 2016
 *  This file is part of Panda Vault.

    Panda Vault is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Panda Vault is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero Public License for more details.

    You should have received a copy of the GNU Affero Public License
    along with Panda Vault.  If not, see <http://www.gnu.org/licenses/>.
 */
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
