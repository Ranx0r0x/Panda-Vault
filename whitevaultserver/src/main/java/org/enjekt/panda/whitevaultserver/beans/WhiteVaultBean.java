package org.enjekt.panda.whitevaultserver.beans;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.Endpoint;
import org.apache.camel.cdi.Uri;
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
