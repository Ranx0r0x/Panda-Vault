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
package org.enjekt.panda.commons.api;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.enjekt.panda.commons.models.Token;


/**
 * The Interface BlackVaultAPI.
 */
public interface BlackVaultAPI {
	
	/**
	 * Gets the pad for token in order to restore the PAN from the panda.
	 *
	 * @param token the token
	 * @return the pad for token
	 */
	@WebMethod(operationName = "getPadForToken", action = "")
	@GET
	@Path("/blackvault/pad/{token}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	public String getPadForToken(@WebParam String token);
	
	/**
	 * Adds the token. When a new token is added the token string and family ID
	 * are taken from the Token and both are used as look ups for the new pad
	 * that will be generated for them.
	 *
	 * @param token the token
	 */
	@WebMethod(operationName = "addToken", action = "")
	@PUT
	@Path("/blackvault/token/{token}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	public void addToken(@WebParam Token token);

	/**
	 * Gets the pads for family ID. This may or may not exist in future versions.  The family ID
	 * is composed of the BIN + last 4 of a PAN.  All PANs that have the same BIN and last four belong
	 * to that family and can be retrieved as a group.
	 *
	 * @param familyId the family id
	 * @return the pads for family ID
	 */
	@WebMethod(operationName = "getPadsForFamilyID", action = "")
	@GET
	@Path("/blackvault/pads/{familyId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	public Map<String,String> getPadsForFamilyID(@WebParam String familyId);
}
