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
 * The Class WhiteVaultDevelopmentDatastore.
 */
@Singleton
public class WhiteVaultDevelopmentDatastore{
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
	
