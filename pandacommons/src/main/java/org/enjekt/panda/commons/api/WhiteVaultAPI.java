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
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.enjekt.panda.commons.models.Pan;
import org.enjekt.panda.commons.models.Token;


/**
 * The Interface WhiteVaultAPI.
 */
public interface WhiteVaultAPI {
	
	/**
	 * Gets the PAN associated with a token.  This is the main entry point for the user to have the Panda Vault
	 * reconstruct the PAN from the separately stored items - the panda and the pad.  The panda is stored in the
	 * White Vault and the pad is in the White Vault.  By retrieving the panda from the White Vault data store and 
	 * the pad from the Black Vault data store, one can subtract the pad from the panda to yield the PAN.
	 * 
	 * This is an extremely fast operation that basically consists of three O(1) operations - look up the panda, 
	 * lookup the pad, subtract the pad from the panda and return the result. That's important as it will
	 * be the most used operation of all.
	 *
	 * @param token the token
	 * @return the pan
	 */
	@WebMethod(operationName = "getPan", action = "")
	@GET
	@Path("/whitevault/token/{token}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Pan getPan(@WebParam Token token);
	
	/**
	 * Adds a new PAN to the system for security.  This is a slower operation due to a number of factors.
	 * First, the handler in the White Vault needs to ensure the there isn't already a token, panda and pad
	 * stored for the given PAN.  It looks the pandas and pads up by their family ID and if it finds one that
	 * matches, it simply returns the token associated with it.  
	 * 
	 * If a token doesn't exist, the white vault handler has to generate a new one and send it to the Black Vault
	 * to create a pad.  That pad then is fetched an added to the PAN in order to create the panda.
	 * Finally the new token and panda along with the family ID are stored in the White Vault.
	 * 
	 * While slower this is acceptable for a number of reasons:
	 * (1) it ensures that a token associated with a PAN is always unique, 
	 * (2) adding a PAN should be a one time operation that doesn't happen again or happens rarely, 
	 * (3) at start up when adding new PANs there will be no pandas or pads associated with a given family ID
	 *     so it will quickly establish that the new PAN is unique and requires a new token, 
	 * (4) even when hundreds of thousands of tokens exist, the family IDs are 10 digits long and are comprised
	 *     of the BIN and the last 4 of the PAN.  The last 4 alone for alone represent 9,999 possible families.
	 *     Adding the BIN does not add a complete 6 digit set of random numbers because there are a limited number
	 *     of BINS.  However, it does differentiate one set of 9,999 possible combinations from another
	 *     set of 9,999 combinations based on which bank issued the card.
	 *
	 * @param pan the pan
	 * @return the string
	 */
	@WebMethod(operationName = "addPan", action = "")
	@PUT
	@Path("/whitevault/pan/{pan}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Token addPan(@WebParam Pan pan);
	
	//TODO delete a PAN based on token - very fast O(1) delete of token/family/panda row and O(1)delete of token/family/pad
}
