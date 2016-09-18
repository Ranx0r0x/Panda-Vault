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

import javax.inject.Named;
import javax.inject.Singleton;

import org.enjekt.panda.commons.models.Token;
import org.enjekt.panda.commons.utils.Utils;

/**
 * The Class TokenGenerator.
 */
@Singleton
@Named("TokenGenerator")
public class TokenGenerator {


	/**
	 * Generate token and make sure it does not pass a luhn check
	 * so it can't be confused with a real card.
	 *
	 * @param pan the pan
	 * @return the token
	 */
	public Token generateToken(String pan) {
		//System.out.println(pan + " in TokenGenerator");
		Boolean luhnValid = Boolean.TRUE;
		Token token;
		do {
			token = Utils.createToken(pan);
			luhnValid=Utils.luhnVerify(token);
		} while(luhnValid);
		//System.out.println("In generator: "+ token);
		return token;
	}

	
	

}
