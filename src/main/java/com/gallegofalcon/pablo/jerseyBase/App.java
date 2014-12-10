package com.gallegofalcon.pablo.jerseyBase;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/srvs")
public class App extends ResourceConfig {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public App() {
		packages(App.class.getPackage().getName());
		register(new ValidationConfigurationContextResolver());
		register(JacksonFeature.class);
	}

}
