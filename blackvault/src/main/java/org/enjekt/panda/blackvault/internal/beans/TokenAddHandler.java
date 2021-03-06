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
package org.enjekt.panda.blackvault.internal.beans;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.enjekt.panda.commons.api.BlackVaultDatastore;
import org.enjekt.panda.commons.models.BlackVaultDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The Class TokenAddHandler.
 */
public class TokenAddHandler  {

	/** The datastore used to store the the tokens and their pads. */
	private BlackVaultDatastore datastore;
	
	public TokenAddHandler(){}
	
	public TokenAddHandler(BlackVaultDatastore datastore){
		this.datastore=datastore; 
	}
	
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
	public void addToken(BlackVaultDataModel bvdm) {
		
		logger.info("Adding this token for generated pad: "+bvdm.getToken()+","+bvdm.getPad());
		datastore.store(bvdm);
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


}
