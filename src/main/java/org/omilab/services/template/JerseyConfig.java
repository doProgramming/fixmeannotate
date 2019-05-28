package org.omilab.services.template;

import org.glassfish.jersey.server.ResourceConfig;
import org.omilab.services.template.rest.PSMConnectorAdmin;
import org.omilab.services.template.rest.PSMConnectorMgmt;
import org.omilab.services.template.rest.PSMConnectorView;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(PSMConnectorAdmin.class);
		register(PSMConnectorMgmt.class);
		register(PSMConnectorView.class);
	}

}
