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
package org.enjekt.panda.commons.models;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class Token.
 */
@XmlRootElement
public class Token {

	/** The token is a randomly generated number which preserves the last 4 digits of the
	 * card for identification purposes.  The token does not pass a luhn check so that
	 * it can't be mistaken for a real card.. */
	private String token;


	public Token(){}
	public Token(String token) {
		this.token=token;
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
	
	public Boolean equals(Token token){
		return token!=null && this.token!=null && this.token.equals(token.getToken());
	}
	@Override
	public String toString() {
		return "Token [token=" + token + "]";
	}

}
