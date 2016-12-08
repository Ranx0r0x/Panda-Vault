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

import java.util.Map;

import org.enjekt.panda.commons.models.Token;


/**
 * The Interface BlackVaultDatastore.
 */
public interface BlackVaultDatastore {

	/**
	 * Store pad for token. The White Vault sends the token to the
	 * Black Vault where a pad is generated. The token string and
	 * family Id are then stored in the database as look ups for the
	 * pad. This may change in the future as technically the family Id
	 * is not required. Without the family Id however, the White Vault has
	 * to make individual calls for each pad in a family it is working with.
	 *
	 * @param token the token
	 * @param pad the pad
	 */
	public void storePadForToken(Token token, String pad);
	
	/**
	 * Gets the pad for token string.  The Black Vault stores the Token by family Id and
	 * the actual token string.  So it is possible to look up an individual pad by the
	 * token string.  This is by far the most common use case and will likely represent
	 * 90% of the operations against the Black Vault.  This is how the user will retreive
	 * an actual PAN for a given token.  The Black Vault returns the pad which is then
	 * subtracted from the panda stored in the White Vault to yield the actual PAN.
	 *
	 * @param token the token
	 * @return the pad for token
	 */
	public String getPadForToken(String token);
	
	/**
	 * Gets the pads for family ID. This may or may not exist in future releases depending on
	 * the impact of separate calls to get pads for tokens.  This is now used when a user adds a new
	 * PAN to the White Vault.  What must first be determined is if the PAN already exists.  Since we
	 * do not store the PAN anywhere it must be reconstructed.  The White Vault retrieves all the pandas
	 * associated with a family ID and all the pads associated with a family ID and subtracts the
	 * pad from the panda to see if the resulting PAN already exists. If so, the token associated wiht
	 * that PAN is returned.  If not, a new token is created for the PAN and the new token is sent to the
	 * Black Vault for a new pad to be created.
	 *
	 * @param familyId the family id
	 * @return the pads for family ID
	 */
	public Map<String, String> getPadsForFamilyID(String familyId);
}
