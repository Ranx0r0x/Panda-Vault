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
package org.enjekt.panda.commons.models;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class Token.
 */
@XmlRootElement
public class Token {

	/** The family id associated with the PAN which is composed of the
	 * BIN and the last 4 digits of the PAN. */
	private String familyId;
	
	/** The token is a randomly generated number which preserves the last 4 digits of the
	 * card for identification purposes.  The token does not pass a luhn check so that
	 * it can't be mistaken for a real card.. */
	private String token;

	/**
	 * Gets the family id.
	 *
	 * @return the family id
	 */
	public String getFamilyId() {
		return familyId;
	}
	
	/**
	 * Sets the family id.
	 *
	 * @param familyId the family id
	 * @return the token
	 */
	public Token setFamilyId(String familyId) {
		this.familyId = familyId;
		return this;
	}
	
	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * Sets the token.
	 *
	 * @param token the token
	 * @return the token
	 */
	public Token setToken(String token) {
		this.token = token;
		return this;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Token [familyId=" + familyId + ", token=" + token + "]";
	}

}
