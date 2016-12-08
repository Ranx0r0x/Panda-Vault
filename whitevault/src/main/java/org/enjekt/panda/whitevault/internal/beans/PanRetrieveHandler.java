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

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.enjekt.panda.commons.api.BlackVaultAPI;
import org.enjekt.panda.commons.api.WhiteVaultDatastore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class PanRetrieveHandler.
 */
@Singleton
@Named("panRetrieveHandler")
public class PanRetrieveHandler {

	private static Logger logger = LoggerFactory.getLogger(PanRetrieveHandler.class);
	/** The datastore to retrieve pandas for tokens.. */
	@Inject
	private WhiteVaultDatastore datastore;

	/** The black vault connector is used to get the pad associated with a token. */
	@Inject
	private BlackVaultAPI blackVaultConnector;

	/**
	 * Gets the pan.
	 *
	 * @param token the token
	 * @return the pan
	 */
	public String getPan(String token) {
		String panda = datastore.getPanda(token);
		String pad = blackVaultConnector.getPadForToken(token);
		logger.info("Panda/pad in PanRetrieveHandler: " + panda +"," + pad);
		String pan;
		if (pad != null && panda != null)
			pan= new BigInteger(panda).subtract(new BigInteger(pad)).toString();
		else
			pan= "INVALID";
		logger.info("Pan after subtraction: "+ pan);
		return pan;
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
