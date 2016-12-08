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
package org.enjekt.panda.whitevaultserver.beans;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.enjekt.panda.commons.api.WhiteVaultAPI;

@Singleton
@Named("whiteVaultBean")
public class WhiteVaultBean  {

	
	private Server server;
	
	@PostConstruct
	public void init()
	{
		System.out.println("Starting JaxWsServerFactory");
		JaxWsServerFactoryBean serverFactory = new JaxWsServerFactoryBean();
		serverFactory.setAddress("localhost:8080/services");
		serverFactory.getInInterceptors().add(new LoggingInInterceptor());
		serverFactory.getOutInterceptors().add(new LoggingOutInterceptor());
		serverFactory.setServiceBean(this);
		serverFactory.setServiceClass(WhiteVaultAPI.class);
	
		server = serverFactory.create();
		server.start();

	}


}
