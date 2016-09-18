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
