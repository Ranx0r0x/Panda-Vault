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
package org.enjekt.panda.blackvault.internal.beans;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.enjekt.panda.commons.api.BlackVaultDatastore;


/**
 * The Class PadRetrieveHandler.
 */
@Singleton
@Named("padRetrieveHandler")
public class PadRetrieveHandler{

	/** The datastore used to store the token and its related pad. */
	@Inject
	BlackVaultDatastore datastore;
	

	/**
	 * Gets the pad for token to be returned to the white vault
	 *
	 * @param token used to identify the pad to be returned.
	 * @return the pad associated with the token which is returned.
	 */
	public String getPadForToken(String token) {
		String pad= datastore.getPadForToken(token);
		return pad;
	}

	/**
	 * Gets the pads for family ID. The familyID identifies a group of pads
	 * that are related by their BIN and last 4 digits.
	 *
	 * @param familyId identifying the group of pads to return.
	 * @return the pads associated with the family ID. The Map contains the tokens
	 * and associated pads to be returned to the white vault
	 */
	public Map<String,String> getPadsForFamilyID(String familyId){
		return datastore.getPadsForFamilyID(familyId);
	}

	/**
	 * Gets the datastore.
	 *
	 * @return the datastore
	 */
	public BlackVaultDatastore getDatastore() {
		return datastore;
	}


	/**
	 * Sets the datastore.
	 *
	 * @param datastore the new datastore
	 */
	public void setDatastore(BlackVaultDatastore datastore) {
		this.datastore = datastore;
	}

}
