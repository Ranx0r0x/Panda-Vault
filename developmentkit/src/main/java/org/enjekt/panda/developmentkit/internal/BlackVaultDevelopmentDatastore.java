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

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import org.enjekt.panda.commons.models.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// TODO: Auto-generated Javadoc
/**
 * The Class BlackVaultDevelopmentDatastore.
 */
@Singleton
public class BlackVaultDevelopmentDatastore {

	/** The data. */
	private HashMap<String,String> data = new HashMap<String,String>();
	
	/** The family id to pads. */
	private HashMap<String,HashMap<String,String>> familyIdToPads = new HashMap<String,HashMap<String,String>>();
	
	/** The logger. */
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
