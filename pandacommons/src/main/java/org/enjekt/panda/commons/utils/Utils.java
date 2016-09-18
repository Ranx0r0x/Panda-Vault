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
package org.enjekt.panda.commons.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.enjekt.panda.commons.models.Token;

// TODO: Auto-generated Javadoc
/**
 * The Class Utils.
 */
public class Utils {
	
	/** The secure random. */
	private static SecureRandom secureRandom=new SecureRandom();
	
	/** The chars. */
	private static char[] chars ={'1','2','3','4','5','6','7','8','9'};
	
	/**
	 * Generate pad.
	 *
	 * @return the big integer
	 */
	public static BigInteger generatePad(){
		 return new BigInteger(generateRandom(16));
	}
	
	/**
	 * Creates the token, the family ID, and the random
	 * token string.
	 *
	 * @param pan the pan
	 * @return the token
	 */
	public static Token createToken(String pan) {
		Token token = new Token();
		String lastFour = Utils.getLastFour(pan);
		String BIN = Utils.getBIN(pan);
		StringBuffer buffer = new StringBuffer();
		buffer.append(Utils.generateRandom(pan.length()-4));
	
		buffer.append(lastFour);
		//System.out.println(buffer.toString());
		token.setFamilyId(BIN+lastFour);
		token.setToken(buffer.toString());
		return token;
	}
	
	/**
	 * Generate random number of the given length between 0...9
	 *
	 * @param length the length
	 * @return the string
	 */
	public static String generateRandom(int length){
		return RandomStringUtils.random(length, 0, 0, false, true, chars,secureRandom );
	}
	
	/**
	 * Gets the bin.
	 *
	 * @param pan the pan
	 * @return the bin
	 */
	public static String getBIN(String pan)
	{
		return pan.substring(0, 6); 
	}
	
	/**
	 * Gets the last four.
	 *
	 * @param pan the pan
	 * @return the last four
	 */
	public static String getLastFour(String pan)
	{
		return pan.substring(pan.length() - 4, pan.length());
	}
	
	/**
	 * Gets the family id for the pan.
	 *
	 * @param pan the pan
	 * @return the family id
	 */
	public static String getFamilyId(String pan){
		 return getBIN(pan)+ getLastFour(pan);
	}


	/**
	 * Luhn verify to make sure the token is not a valid
	 * credit card number
	 *
	 * @param token the token
	 * @return the boolean
	 */
	public static Boolean luhnVerify(Token token) {
		return Utils.luhnVerify(token.getToken());

	}
	
	/**
	 * Luhn verify logic to check the values.
	 *
	 * @param tokenStr the token str
	 * @return the boolean
	 */
	public static Boolean luhnVerify(String tokenStr){
		if(tokenStr==null) return Boolean.FALSE;
		int sum = 0;
		int value;
		int idx = tokenStr.length(); // Start from the end of string
		boolean alt = false;

		while (idx-- > 0) {
			// Get value. Throws error if it isn't a digit
			value = Integer.parseInt(tokenStr.substring(idx, idx + 1));
			if (alt) {
				value *= 2;
				if (value > 9)
					value -= 9;
			}
			sum += value;
			alt = !alt; // Toggle alt-flag
		}
		return (sum % 10) == 0;
	}
}
