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
package org.enjekt.panda.blackvault.internal.beans;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.enjekt.panda.commons.api.BlackVaultDatastore;
import org.enjekt.panda.commons.models.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The Class TokenAddHandler.
 */
@Singleton
@Named("tokenAddHandler")
public class TokenAddHandler  {

	/** The datastore used to store the the tokens and their pads. */
	@Inject
	BlackVaultDatastore datastore;
	
	/** The pad generator which generates a pad with the same length as the token. */
	@Inject
	PadGenerator generator;
	
	Logger logger = LoggerFactory.getLogger(TokenAddHandler.class);
	/**
	 * Generates the pad to be associated with the token and stores it with the 
	 * token and the pad.  The data store will use the token string and the family Id 
	 * to make the pads available to the white vault.
	 * 
	 * Note.  Adding the token does not return the pad.  It may be desirable to add a large number
	 * of tokens while not requiring them to be returned.  A case might be when a user
	 * first starts using the Panda Vault and wants to add all their pans without retrieving them
	 * in a transaction.
	 *
	 * @param token the token
	 */
	public void addToken(Token token) {
		String pad = generator.generatePad(token.getToken());
		logger.info("Adding this token for generated pad: "+token.getToken()+","+pad);
		datastore.storePadForToken(token, pad);
	}


	/**
	 * Gets the datastore.
	 *
	 * @return the datastore
	 */
	public BlackVaultDatastore getDatastore() {
		return datastore;
	}


	/**
	 * Sets the datastore.
	 *
	 * @param datastore the new datastore
	 */
	public void setDatastore(BlackVaultDatastore datastore) {
		this.datastore = datastore;
	}


	/**
	 * Gets the generator.
	 *
	 * @return the generator
	 */
	public PadGenerator getGenerator() {
		return generator;
	}


	/**
	 * Sets the generator.
	 *
	 * @param generator the new generator
	 */
	public void setGenerator(PadGenerator generator) {
		this.generator = generator;
	}

}
