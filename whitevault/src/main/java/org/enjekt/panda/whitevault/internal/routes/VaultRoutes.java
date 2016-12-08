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
