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

import javax.inject.Named;
import javax.inject.Singleton;

import org.enjekt.panda.commons.utils.Utils;


/**
 * The Class PadGenerator.
 */
@Singleton
@Named("PadGenerator")
public class PadGenerator {


	/**
	 * Generate pad that is used to .
	 *
	 * @param The token associated with the new pad.
	 * @return the pad for this token.
	 */
	public String generatePad(String token) {
		return Utils.generateRandom(token.length());
	}
	

	

}
