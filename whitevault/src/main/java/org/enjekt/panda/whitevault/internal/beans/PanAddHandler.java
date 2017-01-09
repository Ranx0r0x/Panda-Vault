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
package org.enjekt.panda.whitevault.internal.beans;

import java.math.BigInteger;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.enjekt.panda.commons.api.BlackVaultAPI;
import org.enjekt.panda.commons.api.WhiteVaultDatastore;
import org.enjekt.panda.commons.models.BlackVaultDataModel;
import org.enjekt.panda.commons.models.FamilyId;
import org.enjekt.panda.commons.models.Pad;
import org.enjekt.panda.commons.models.Pan;
import org.enjekt.panda.commons.models.Panda;
import org.enjekt.panda.commons.models.Token;
import org.enjekt.panda.commons.models.WhiteVaultDataModel;
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
	public Token addPan(Pan pan) {

		Token token = fetchExistingToken(pan);
		System.out.println("FETCHED TOKEN: " + token);
		if (token == null) {
			token = createNewToken(pan);

		}

		return token;
	}

	/**
	 * Fetch existing token.
	 *
	 * @param pan the pan
	 * @return the token
	 */
	private Token fetchExistingToken(Pan pan) {
		FamilyId familyId = Utils.createFamilyId(pan.getPan());
		logger.info("Family ID of tokens: " + familyId.getId());
		Map<String, Pad> tokensToPads = blackVaultConnector.getPadsForFamilyID(familyId);
		Map<String, Panda> tokensToPandas = datastore.getPandasForFamilyID(familyId);
		logger.info("tokensToPads: " + tokensToPads);
		logger.info("tokensToPandas: " + tokensToPandas);
		if (tokensToPandas == null && tokensToPads == null)
			return null;
		for (String token : tokensToPads.keySet()) {
			System.out.println("TOKEN: " + token);
			Panda panda = tokensToPandas.get(token);
			System.out.println("PANDA: " + panda);
			Pad pad = tokensToPads.get(token);
			System.out.println("PAD: " + pad);
			System.out.println(panda +","+pad);
			String panToCheck = new BigInteger(panda.getPanda()).subtract(new BigInteger(pad.getPad())).toString();
			System.out.println("PAN FOUND: " + pan.getPan().equals(panToCheck) );
			if (pan.getPan().equals(panToCheck))
				return new Token(token);
		}

		return new Token("Not found");
	}

	/**
	 * Creates the new token.
	 *
	 * @param pan the pan
	 * @return the token
	 */
	private Token createNewToken(Pan pan) {
		Token token = tokenGenerator.generateToken(pan);
		Pad pad =  tokenGenerator.generatePad(pan);
		FamilyId familyId = Utils.createFamilyId(pan);
		blackVaultConnector.addToken(new BlackVaultDataModel(token,pad, familyId));

		Panda panda = Utils.createPanda(pan,pad);
		logger.info("Pan and pad for new token: " + pan + "," + pad);
		
		datastore.storePanda(new WhiteVaultDataModel(token, panda, familyId));
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
