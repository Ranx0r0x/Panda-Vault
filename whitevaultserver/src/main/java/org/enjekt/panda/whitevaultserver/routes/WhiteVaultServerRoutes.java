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
package org.enjekt.panda.whitevaultserver.routes;

import javax.inject.Inject;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.Uri;
import org.enjekt.panda.whitevaultserver.beans.WhiteVaultBean;

public class WhiteVaultServerRoutes extends RouteBuilder {

	public static final String GET_PAN = "direct-vm:getPan";
	public static final String ADD_PAN = "direct-vm:addPan";


	public WhiteVaultServerRoutes(){}
	@Inject
	@Uri(GET_PAN)
	private Endpoint getPan;
	
	@Inject
	@Uri(ADD_PAN)
	private Endpoint addPan;
	
	@Inject
	WhiteVaultBean whiteVaultBean;


	@Override
    public void configure() {
        // you can configure the route rule with Java DSL here

        from("bean:whiteVaultBean")
        	.to(getPan);
        
        from("bean:whiteVaultBean")
            .to(addPan);
        

    	
	}
}

