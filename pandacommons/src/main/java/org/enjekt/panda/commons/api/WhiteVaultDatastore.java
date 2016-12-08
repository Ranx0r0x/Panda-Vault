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
