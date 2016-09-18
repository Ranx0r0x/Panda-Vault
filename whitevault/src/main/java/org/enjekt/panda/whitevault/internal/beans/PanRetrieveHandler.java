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
