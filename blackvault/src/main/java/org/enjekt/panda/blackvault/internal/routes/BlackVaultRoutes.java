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
package org.enjekt.panda.blackvault.internal.routes;


import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.enjekt.panda.blackvault.internal.beans.PadRetrieveHandler;
import org.enjekt.panda.blackvault.internal.beans.PadsForFamilyHandler;
import org.enjekt.panda.blackvault.internal.beans.TokenAddHandler;

/**
 * Configures all our Camel routes, components, endpoints and beans
 */
public class BlackVaultRoutes extends RouteBuilder {
	public static final String GET_PAD = "direct-vm:getPad";
	public static final String ADD_TOKEN= "direct-vm:addToken";
	public static final String GET_PAD_LIST= "direct-vm:getPads";

	@Inject
	TokenAddHandler tokenAddHandler;
	@Inject
	PadRetrieveHandler padRetrieveHandler;
	@Inject
	PadsForFamilyHandler padsForFamilyHandler;
	
	public BlackVaultRoutes(){}

	@Override
    public void configure() {

        from(GET_PAD)
        	.bean(padRetrieveHandler);
        
        from(ADD_TOKEN)
            .bean(tokenAddHandler);
        
        from(GET_PAD_LIST)
        	.bean(padsForFamilyHandler);
        
    	
	}

	public TokenAddHandler getTokenAddHandler() {
		return tokenAddHandler;
	}

	public void setTokenAddHandler(TokenAddHandler tokenAddHandler) {
		this.tokenAddHandler = tokenAddHandler;
	}

	public PadRetrieveHandler getPadRetrieveHandler() {
		return padRetrieveHandler;
	}

	public void setPadRetrieveHandler(PadRetrieveHandler padRetrieveHandler) {
		this.padRetrieveHandler = padRetrieveHandler;
	}

	public PadsForFamilyHandler getPadsForFamilyHandler() {
		return padsForFamilyHandler;
	}

	public void setPadsForFamilyHandler(PadsForFamilyHandler padsForFamilyHandler) {
		this.padsForFamilyHandler = padsForFamilyHandler;
	}

}
