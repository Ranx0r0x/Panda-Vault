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
package org.enjekt.panda.whitevault.internal.beans;

import java.math.BigInteger;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.enjekt.panda.commons.api.BlackVaultAPI;
import org.enjekt.panda.commons.api.WhiteVaultDatastore;
import org.enjekt.panda.commons.models.Token;
import org.enjekt.panda.commons.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class PanAddHandler. 
 */
//TODO The logging statements have to be stripped out or modify in the future to ensure
//that PAN data or any data related to tokens, pandas or pads are revealed in the log
//files
@Singleton
@Named("panAddHandler")
public class PanAddHandler {
	
	private static Logger logger = LoggerFactory.getLogger(PanAddHandler.class);

	/** The datastore where tokens, family ID and panda rows are stored.. */
	@Inject
	private WhiteVaultDatastore datastore;

	/** The token generator is used to generate new tokens for PANs. */
	@Inject
	private TokenGenerator tokenGenerator;

	/** The black vault connector is used to add new tokens to the Black Vault and
	 * to retrieve the pads associated with those tokens. */
	@Inject
	private BlackVaultAPI blackVaultConnector;

	/**
	 * Adds the pan by checking to see if one already exists and then creating
	 * a new one if it doesn't. It then returns the new or existing token for
	 * the given pan.
	 *
	 * @param pan the pan
	 * @return the string
	 */
	public String addPan(String pan) {

		Token token = fetchExistingToken(pan);
		if (token == null) {
			token = createNewToken(pan);

		}

		return token.getToken();
	}

	/**
	 * Fetch existing token.
	 *
	 * @param pan the pan
	 * @return the token
	 */
	private Token fetchExistingToken(String pan) {
		String familyId = Utils.getFamilyId(pan);
		logger.info("Family ID of tokens: " + familyId);
		Map<String, String> tokensToPads = blackVaultConnector.getPadsForFamilyID(familyId);
		Map<String, String> tokensToPandas = datastore.getPandasForFamilyID(familyId);
		logger.info("maps" + tokensToPads + "," + tokensToPandas);
		if (tokensToPandas == null && tokensToPads == null)
			return null;
		for (String token : tokensToPads.keySet()) {
			String panToCheck = new BigInteger(tokensToPandas.get(token)).subtract(new BigInteger(tokensToPads.get(token))).toString();
			logger.info(panToCheck);
			logger.info(pan);
			if (pan.equals(panToCheck))
				return new Token().setToken(token).setFamilyId(familyId);
		}
		return null;
	}

	/**
	 * Creates the new token.
	 *
	 * @param pan the pan
	 * @return the token
	 */
	private Token createNewToken(String pan) {
		Token token = tokenGenerator.generateToken(pan);
		blackVaultConnector.addToken(token);
		String pad = blackVaultConnector.getPadForToken(token.getToken());
		String panda = new BigInteger(pan).add(new BigInteger(pad)).toString();
		logger.info("Pan and pad for new token: " + pan + "," + pad);
		
		if (pad == null || panda == null)
			token = new Token().setToken("INVALID");
		else
			datastore.storePanda(token, panda);
		return token;
	}

	/**
	 * Gets the token generator.
	 *
	 * @return the token generator
	 */
	public TokenGenerator getTokenGenerator() {
		return tokenGenerator;
	}

	/**
	 * Sets the token generator.
	 *
	 * @param tokenGenerator the new token generator
	 */
	public void setTokenGenerator(TokenGenerator tokenGenerator) {
		this.tokenGenerator = tokenGenerator;
	}

	/**
	 * Gets the black vault connector.
	 *
	 * @return the black vault connector
	 */
	public BlackVaultAPI getBlackVaultConnector() {
		return blackVaultConnector;
	}

	/**
	 * Sets the black vault connector.
	 *
	 * @param blackVaultConnector the new black vault connector
	 */
	public void setBlackVaultConnector(BlackVaultAPI blackVaultConnector) {
		this.blackVaultConnector = blackVaultConnector;
	}

	/**
	 * Gets the datastore.
	 *
	 * @return the datastore
	 */
	public WhiteVaultDatastore getDatastore() {
		return datastore;
	}

	/**
	 * Sets the datastore.
	 *
	 * @param datastore the new datastore
	 */
	public void setDatastore(WhiteVaultDatastore datastore) {
		this.datastore = datastore;
	}

}
