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
package org.enjekt.panda.developmentkit.internal;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.cdi.Uri;
import org.enjekt.panda.commons.api.BlackVaultAPI;
import org.enjekt.panda.commons.models.Token;

// TODO: Auto-generated Javadoc
/**
 * The Class BlackVaultConnectorImpl.
 */

@Singleton
@Named("blackVaultConnector")
public class BlackVaultConnectorImpl implements BlackVaultAPI {
	
	/** The Constant GET_PAD. */
	public static final String GET_PAD = "direct-vm:getPad";
	
	/** The Constant ADD_TOKEN. */
	public static final String ADD_TOKEN= "direct-vm:addToken";
	
	/** The Constant GET_PAD_LIST. */
	public static final String GET_PAD_LIST= "direct-vm:getPads";
	
    /** Get the pad for a given token uses this producer template to call the black vault. */
    @Inject
    @Uri(GET_PAD)
    @EndpointInject(uri=GET_PAD)
    private ProducerTemplate getPad;
    
    /** The addToken uses this producer template to call the black vault. */
    @Inject
    @Uri(ADD_TOKEN)
    @EndpointInject(uri=ADD_TOKEN)
    private ProducerTemplate addToken;
    
    /** The getPads producer template is used to cal the black vault to get the list of
     * pads associated with a family ID.. */
    @Inject
    @Uri(GET_PAD_LIST)
    @EndpointInject(uri=GET_PAD_LIST)
    private ProducerTemplate getPads;


	/* (non-Javadoc)
	 * @see org.enjekt.panda.commons.api.BlackVaultAPI#getPadForToken(java.lang.String)
	 */
	@Override
	public String getPadForToken(String token) {
		return (String) getPad.requestBody(token);
	}


	/* (non-Javadoc)
	 * @see org.enjekt.panda.commons.api.BlackVaultAPI#addToken(org.enjekt.panda.commons.models.Token)
	 */
	@Override
	public void addToken(Token token) {
		addToken.sendBody(token);
		
	}

	/* (non-Javadoc)
	 * @see org.enjekt.panda.commons.api.BlackVaultAPI#getPadsForFamilyID(java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Map<String,String> getPadsForFamilyID(String familyId) {
		return (Map<String,String>) getPads.requestBody(familyId);
	}

}
