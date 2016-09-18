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
package org.enjekt.panda.blackvault.internal.routes;


import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.enjekt.panda.blackvault.internal.beans.PadRetrieveHandler;
import org.enjekt.panda.blackvault.internal.beans.TokenAddHandler;

/**
 * Configures all our Camel routes, components, endpoints and beans
 */
public class VaultRoutes extends RouteBuilder {


	public static final String GET_PAD = "direct-vm:getPad";
	public static final String ADD_TOKEN= "direct-vm:addToken";
	public static final String GET_PAD_LIST= "direct-vm:getPads";
	@Inject
	TokenAddHandler tokenAddHandler;
	@Inject
	PadRetrieveHandler padRetrieveHandler;
	
	public VaultRoutes(){}

	@Override
    public void configure() {

        from(GET_PAD)
        	.bean(padRetrieveHandler,"getPadForToken");
        
        from(ADD_TOKEN)
            .bean(tokenAddHandler);
        
        from(GET_PAD_LIST)
        	.bean(padRetrieveHandler,"getPadsForFamilyID");
        
    	
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

}
