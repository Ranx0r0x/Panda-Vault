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

