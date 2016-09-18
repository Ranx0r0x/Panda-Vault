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

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import org.enjekt.panda.commons.models.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The Class BlackVaultDevelopmentDatastore.
 */
@Singleton
public class BlackVaultDevelopmentDatastore {

	/** The data. */
	private HashMap<String,String> data = new HashMap<String,String>();
	
	/** The family id to pads. */
	private HashMap<String,HashMap<String,String>> familyIdToPads = new HashMap<String,HashMap<String,String>>();
	
	Logger logger = LoggerFactory.getLogger(BlackVaultDevelopmentDatastore.class);
	/**
	 * Gets the pad for token.
	 *
	 * @param token the token
	 * @return the pad for token
	 */
	public String getPadForToken(String token) {
		String pad  = data.get(token);
		logger.info("Returning pad for token from black vault: " + token +"," + pad);
		return pad;
	}

	
	/**
	 * The Black Vault uses this method to store the token and its generated pad. 
	 *
	 * @param token the token
	 * @param pad the pad
	 */
	public void storePadForToken(Token token, String pad) {
		logger.info("Black vault data store token/pad: "+ token.getToken() +","+pad);
		data.put(token.getToken(), pad);
		HashMap<String,String> tokensToPadMap=familyIdToPads.get(token.getFamilyId());
		if(tokensToPadMap==null){
			tokensToPadMap= new HashMap<String,String>();
			familyIdToPads.put(token.getFamilyId(),tokensToPadMap);
		}
		tokensToPadMap.put(token.getToken(), pad);
	}


	/**
	 * Gets the pads for family ID.
	 *
	 * @param familyId the family id
	 * @return the pads for family ID
	 */
	public Map<String, String> getPadsForFamilyID(String familyId) {
		return familyIdToPads.get(familyId);
	}

}
