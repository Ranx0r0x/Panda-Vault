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
