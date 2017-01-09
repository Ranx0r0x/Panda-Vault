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

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;

import org.enjekt.panda.commons.models.FamilyId;
import org.enjekt.panda.commons.models.Pad;
import org.enjekt.panda.commons.models.Token;
import org.enjekt.panda.commons.api.BlackVaultDatastore;
import org.enjekt.panda.commons.models.BlackVaultDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The Class BlackVaultDevelopmentDatastore.
 */

@Named("blackVaultDevelopmentDatastore")
public class BlackVaultDevelopmentDatastore implements BlackVaultDatastore {

	/** The data. */
	private HashMap<String,Pad> data = new HashMap<String,Pad>();
	
	/** The family id to pads. */
	private HashMap<String,HashMap<String,Pad>> familyIdToPads = new HashMap<String,HashMap<String,Pad>>();
	
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(BlackVaultDevelopmentDatastore.class);
	/**
	 * Gets the pad for token.
	 *
	 * @param token the token
	 * @return the pad for token
	 */
	public Pad getPadForToken(Token token) {
		return data.get(token.getToken());
	}

	/**
	 * Gets the pads for family ID.
	 *
	 * @param familyId the family id
	 * @return the pads for family ID
	 */
	public HashMap<String, Pad> getPadsForFamilyID(FamilyId familyId) {
		return familyIdToPads.get(familyId.getId());
	}

	
	/**
	 * The Black Vault uses this method to store the token and its generated pad. 
	 *
	 * @param token the token
	 * @param pad the pad
	 */
	@Override
	public void store(BlackVaultDataModel bvdm) {
		logger.info("Black vault data store token/pad: "+ bvdm.getToken() +","+bvdm.getPad());
		data.put(bvdm.getToken().getToken(), bvdm.getPad());
		HashMap<String,Pad> tokensToPadMap=familyIdToPads.get(bvdm.getFamilyId());
		if(tokensToPadMap==null){
			tokensToPadMap= new HashMap<String,Pad>();
			familyIdToPads.put(bvdm.getFamilyId().getId(),tokensToPadMap);
		}
		tokensToPadMap.put(bvdm.getToken().getToken(), bvdm.getPad());
		System.out.println(tokensToPadMap);
	}



}
