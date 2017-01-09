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

import org.enjekt.panda.commons.api.WhiteVaultDatastore;
import org.enjekt.panda.commons.models.FamilyId;
import org.enjekt.panda.commons.models.Panda;
import org.enjekt.panda.commons.models.Token;
import org.enjekt.panda.commons.models.WhiteVaultDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class WhiteVaultDevelopmentDatastore.
 */
@Singleton
@Named("whiteVaultDatastore")
public class WhiteVaultDevelopmentDatastore implements WhiteVaultDatastore{
		
		/** The logger. */
		private static Logger logger = LoggerFactory.getLogger(WhiteVaultDevelopmentDatastore.class);
		
		/** The panda to token map which allows reverse look up of panda for given token. */
		private HashMap<String,String> pandaToToken = new HashMap<String,String>();
		
		/** The token to panda map which is used during a look up of a PAN associated with
		 * a given token.  Since the PAN is not actually stored anywhere it has to be 
		 * reconstituted by getting the panda from the white vault and the pad from the black
		 * vault and subtracting them. */
		private HashMap<String,Panda> tokenToPanda = new HashMap<String,Panda>();
		
		/** The family Id to pandas. During adding PANs it is important to know that they don't already
		 * exist.  The only way to do this is to return the pandas associated with a given family Id which
		 * is composed of the BIN + last four digits of the pan.  One must also then get the map of pads
		 * associated with the family ID.  Theoretically one could make individual calls to the Black Vault
		 * to return single pads associated with each token.  This would be slower but perhaps a bit more 
		 * secure since the family Id would not be stored in the Black Vault.  
		 * 
		 * However, it is common practice to include the BIN and last 4 as part of any token and we currently
		 * choose not to expose that information on the tokens.  Only the last 4 are used in the tokens. */
		private Map<String, HashMap<String, Panda>> familyToPandas = new HashMap<String,HashMap<String,Panda>>();
		
		/**
		 * Gets the token associated with a panda..
		 *
		 * @param panda the panda
		 * @return the token
		 */
		public Token getToken(Panda panda) {
			Token token = new Token();
			token.setToken(pandaToToken.get(panda.getPanda()));
			return token;
		}

		/**
		 * Gets the panda.
		 *
		 * @param token the token
		 * @return the panda
		 */
		public Panda getPanda(Token token) {
			return tokenToPanda.get(token.getToken());
		}

		/**
		 * Store the panda associated with a given token.  Both the family ID and
		 * the token string are used to store the panda for subsequent look up.
		 *
		 * @param token the token
		 * @param panda the panda
		 */
		public void storePanda(WhiteVaultDataModel wvdm) {
	
			logger.info("Store token: "+wvdm.getToken()+","+wvdm.getPanda());
			tokenToPanda.put(wvdm.getToken().getToken(), wvdm.getPanda());
			pandaToToken.put(wvdm.getPanda().getPanda(),wvdm.getToken().getToken());
			HashMap<String,Panda> tokensToPandas =familyToPandas.get(wvdm.getFamilyId().getId());
			if(tokensToPandas==null){
				tokensToPandas = new HashMap<String,Panda>();
				familyToPandas.put(wvdm.getFamilyId().getId(),tokensToPandas);
			}
			tokensToPandas.put(wvdm.getToken().getToken(),wvdm.getPanda());
			
		}

		/**
		 * Gets the pandas for family ID.
		 *
		 * @param familyId the family id
		 * @return the pandas for family ID
		 */

		@Override
		public Map<String, Panda> getPandasForFamilyID(FamilyId familyId) {
			return familyToPandas.get(familyId.getId());
		}
		
	}
	
