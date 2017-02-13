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
package org.enjekt.panda.commons.api;

import org.enjekt.panda.commons.models.FamilyId;
import org.enjekt.panda.commons.models.FamilyPandaCollection;
import org.enjekt.panda.commons.models.Panda;
import org.enjekt.panda.commons.models.Token;
import org.enjekt.panda.commons.models.WhiteVaultDataModel;

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
	public Token getToken(Panda panda);
	
	/**
	 * Store panda based on the family ID, token string, and panda.
	 *
	 * @param token the token
	 * @param panda the panda
	 */
	public void storePanda(WhiteVaultDataModel whiteVaultDataModel);
	
	/**
	 * Gets the panda associated with a token string.
	 *
	 * @param token the token
	 * @return the panda
	 */
	public Panda getPanda(Token token);
	
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
	public FamilyPandaCollection getPandasForFamilyID(FamilyId familyId);


	
}
