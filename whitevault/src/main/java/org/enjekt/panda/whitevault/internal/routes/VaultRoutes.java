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
package org.enjekt.panda.whitevault.internal.routes;


import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.enjekt.panda.whitevault.internal.beans.PanAddHandler;
import org.enjekt.panda.whitevault.internal.beans.PanRetrieveHandler;


/**
 * Configures all our Camel routes, components, endpoints and beans.
 */
public class VaultRoutes extends RouteBuilder {

	/** The Constant GET_PAN. */
	public static final String GET_PAN = "direct-vm:getPan";
	
	/** The Constant ADD_PAN. */
	public static final String ADD_PAN = "direct-vm:addPan";


	/**
	 * Instantiates a new vault routes.
	 */
	public VaultRoutes(){}
	
	/** The pan retrieve handler. */
	@Inject
	private PanRetrieveHandler panRetrieveHandler;
	
	/** The pan add handler. */
	@Inject
	private PanAddHandler panAddHandler;
	
	/* (non-Javadoc)
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	@Override
    public void configure() {
        // you can configure the route rule with Java DSL here

        from(GET_PAN)
        	.bean(panRetrieveHandler);
        
        from(ADD_PAN)
            .bean(panAddHandler);

  
    	
	}

	/**
	 * Gets the pan retrieve handler.
	 *
	 * @return the pan retrieve handler
	 */
	public PanRetrieveHandler getPanRetrieveHandler() {
		return panRetrieveHandler;
	}

	/**
	 * Sets the pan retrieve handler.
	 *
	 * @param panRetrieveHandler the new pan retrieve handler
	 */
	public void setPanRetrieveHandler(PanRetrieveHandler panRetrieveHandler) {
		this.panRetrieveHandler = panRetrieveHandler;
	}

	/**
	 * Gets the pan add handler.
	 *
	 * @return the pan add handler
	 */
	public PanAddHandler getPanAddHandler() {
		return panAddHandler;
	}

	/**
	 * Sets the pan add handler.
	 *
	 * @param panAddHandler the new pan add handler
	 */
	public void setPanAddHandler(PanAddHandler panAddHandler) {
		this.panAddHandler = panAddHandler;
	}

}
