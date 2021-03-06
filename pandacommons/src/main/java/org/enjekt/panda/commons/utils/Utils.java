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
package org.enjekt.panda.commons.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.enjekt.panda.commons.models.FamilyId;
import org.enjekt.panda.commons.models.Pad;
import org.enjekt.panda.commons.models.Pan;
import org.enjekt.panda.commons.models.Panda;
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
	 * Creates the token, the family ID, and the random
	 * token string.
	 *
	 * @param pan the pan
	 * @return the token
	 */
	public static Token createToken(Pan pan) {
		return createToken(pan.getPan());
	}
	public static Token createToken(String pan) {
		Token token = new Token();
		String lastFour = Utils.getLastFour(pan);
		String BIN = Utils.getBIN(pan);
		StringBuffer buffer = new StringBuffer();
		buffer.append(BIN);
		int lengthOfRandom = pan.length()-BIN.length()-4;
		buffer.append(Utils.generateRandom(lengthOfRandom));
		buffer.append(lastFour);

		token.setToken(buffer.toString());
		return token;
	}
	/**
	 * Gets the family id for the pan.
	 *
	 * @param pan the pan
	 * @return the family id
	 */
	public static FamilyId createFamilyId(Pan pan){
		 
		 return createFamilyId(pan.getPan());
	}
	/**
	 * Gets the family id for the pan.
	 *
	 * @param pan the pan
	 * @return the family id
	 */
	public static FamilyId createFamilyId(String pan){
		 
		 return new FamilyId(getBIN(pan)+ getLastFour(pan));
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

	public static Pad createPad(Pan pan) {
		return createPad(pan.getPan());
		
	}
	public static Pad createPad(String pan) {
		return new Pad(Utils.generateRandom(pan.length()));
		
	}
	public static Panda createPanda(Pan pan, Pad pad) {
		return createPanda(pan.getPan(),pad.getPad());
	}
	
	public static Panda createPanda(String pan, String pad){

		return new Panda(new BigInteger(pan).add(new BigInteger(pad)).toString());
	}
	

}
