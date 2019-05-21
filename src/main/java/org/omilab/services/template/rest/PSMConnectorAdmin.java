package org.omilab.services.template.rest;

import org.omilab.services.template.model.GenericRequest;
import org.omilab.services.template.model.GenericServiceContent;
import org.omilab.services.template.service.InstanceMgmtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Component
@Path("/admin")
public final class PSMConnectorAdmin {

	private static final Logger logger = LoggerFactory.getLogger(PSMConnectorAdmin.class);

	private final InstanceMgmtService instances;

	private final Environment env;

	@Autowired
	public PSMConnectorAdmin(InstanceMgmtService instances, Environment env) {
		this.instances = instances;
		this.env = env;
	}

	@POST
	@Path("/{instanceid}/{endpoint}")
	@Produces("application/json")
	public GenericServiceContent processAdmin(final GenericRequest request,
											  final @PathParam("instanceid") Long instanceid,
											  final @PathParam("endpoint") String endpoint,
											  final @Context HttpServletRequest servletRequest) {

		if(!instances.checkAccess(servletRequest.getRemoteAddr(), instanceid)) {
			logger.error("API call to instance with invalid IP detected. Enable debug log for more information...");
			logger.debug("Request IP: " + servletRequest.getRemoteAddr() + " Instanceid: " + instanceid);
			return new GenericServiceContent("Not allowed!");
		}

		//Implement me!

		return new GenericServiceContent("Hello world!");
	}

}
