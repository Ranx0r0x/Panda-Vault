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
 * The Class WhiteVaultDevelopmentDatastore.
 */
@Singleton
public class WhiteVaultDevelopmentDatastore{
		
		/** The logger. */
		private static Logger logger = LoggerFactory.getLogger(WhiteVaultDevelopmentDatastore.class);
		
		/** The panda to token map which allows reverse look up of panda for given token. */
		private HashMap<String,String> pandaToToken = new HashMap<String,String>();
		
		/** The token to panda map which is used during a look up of a PAN associated with
		 * a given token.  Since the PAN is not actually stored anywhere it has to be 
		 * reconstituted by getting the panda from the white vault and the pad from the black
		 * vault and subtracting them. */
		private HashMap<String,String> tokenToPanda = new HashMap<String,String>();
		
		/** The family Id to pandas. During adding PANs it is important to know that they don't already
		 * exist.  The only way to do this is to return the pandas associated with a given family Id which
		 * is composed of the BIN + last four digits of the pan.  One must also then get the map of pads
		 * associated with the family ID.  Theoretically one could make individual calls to the Black Vault
		 * to return single pads associated with each token.  This would be slower but perhaps a bit more 
		 * secure since the family Id would not be stored in the Black Vault.  
		 * 
		 * However, it is common practice to include the BIN and last 4 as part of any token and we currently
		 * choose not to expose that information on the tokens.  Only the last 4 are used in the tokens. */
		private Map<String, HashMap<String, String>> familyToPandas = new HashMap<String,HashMap<String,String>>();
		
		/**
		 * Gets the token associated with a panda..
		 *
		 * @param panda the panda
		 * @return the token
		 */
		public Token getToken(String panda) {
			Token token = new Token();
			token.setToken(pandaToToken.get(panda));
			return token;
		}

		/**
		 * Gets the panda.
		 *
		 * @param token the token
		 * @return the panda
		 */
		public String getPanda(String token) {
			System.out.println("Get panda: "+ tokenToPanda.get(token));
			return tokenToPanda.get(token);
		}

		/**
		 * Store the panda associated with a given token.  Both the family ID and
		 * the token string are used to store the panda for subsequent look up.
		 *
		 * @param token the token
		 * @param panda the panda
		 */
		public void storePanda(Token token, String panda) {
			logger.info("Store token: "+token.getToken()+","+panda);
			tokenToPanda.put(token.getToken(), panda);
			pandaToToken.put(panda,token.getToken());
			HashMap<String,String> tokensToPandas =familyToPandas.get(token.getFamilyId());
			if(tokensToPandas==null){
				tokensToPandas = new HashMap<String,String>();
				familyToPandas.put(token.getFamilyId(),tokensToPandas);
			}
			tokensToPandas.put(token.getToken(),panda);
			
		}

		/**
		 * Gets the pandas for family ID.
		 *
		 * @param familyId the family id
		 * @return the pandas for family ID
		 */
		public Map<String,String> getPandasForFamilyID(String familyId) {
				return familyToPandas.get(familyId);
		}
		
	}
	
