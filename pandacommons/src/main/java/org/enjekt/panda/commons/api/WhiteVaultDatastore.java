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
package org.enjekt.panda.commons.api;

import java.util.Map;

import org.enjekt.panda.commons.models.Token;

/**
 * The Interface WhiteVaultDatastore.
 */
public interface WhiteVaultDatastore {

	/**
	 * Gets the token associated with a panda.
	 *
	 * @param pan the panda.
	 * @return the token
	 * 
	 * 
	 */
	//TODO This should probably be deprecated as I don't think there are any cases for it.
	public Token getToken(String panda);
	
	/**
	 * Store panda based on the family ID, token string, and panda.
	 *
	 * @param token the token
	 * @param panda the panda
	 */
	public void storePanda(Token token,String panda);
	
	/**
	 * Gets the panda associated with a token string.
	 *
	 * @param token the token
	 * @return the panda
	 */
	public String getPanda(String token);
	
	/**
	 * Gets the pandas for family ID is used when adding a new token.
	 * This is required when adding a new PAN so that we can check if
	 * the PAN already exists.  If the Map is not empty we know the 
	 * PAN may already have been added so we need to reconstruct the PANs
	 * associated with that family ID and check them against the PAN being 
	 * added.  If there are no matches, we create a new token, pad and panda
	 * and return the new token.  If a match is found we return the already
	 * existing token.
	 *
	 * @param familyId the family id
	 * @return the pandas for family ID
	 */
	public Map<String,String> getPandasForFamilyID(String familyId);

	
}
