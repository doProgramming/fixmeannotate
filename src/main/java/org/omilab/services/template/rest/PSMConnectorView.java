package org.omilab.services.template.rest;

import org.omilab.services.template.model.GenericServiceContent;
import org.omilab.services.template.service.InstanceMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.HashMap;

@Component
@Path("/view")
public final class PSMConnectorView {

	private final InstanceMgmtService instanceMgmtService;

	@Autowired
	public PSMConnectorView(InstanceMgmtService instanceMgmtService) {
		this.instanceMgmtService = instanceMgmtService;
	}

	@POST
	@Path("/{instanceid}/{endpoint}")
	@Produces("application/json")
	@Consumes("application/json")
	public GenericServiceContent processRequest(final @PathParam("instanceid") Long instanceid,
												final @PathParam("endpoint") String endpoint,
												final @Context HttpServletRequest servletRequest) {

		if(!instanceMgmtService.checkAccess(servletRequest.getRemoteAddr(), instanceid))
			return new GenericServiceContent("Not allowed!");

		//Implement me!

		return new GenericServiceContent("Hello world!", new HashMap<String,String>());
	}



}