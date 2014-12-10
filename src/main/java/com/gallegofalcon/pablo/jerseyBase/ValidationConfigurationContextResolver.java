package com.gallegofalcon.pablo.jerseyBase;

import org.glassfish.jersey.server.validation.ValidationConfig;
import org.glassfish.jersey.server.validation.internal.InjectingConstraintValidatorFactory;

import javax.validation.ParameterNameProvider;
import javax.validation.Validation;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.ContextResolver;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class ValidationConfigurationContextResolver implements ContextResolver<ValidationConfig> {

	@Context
	private ResourceContext resourceContext;

	public ValidationConfig getContext(final Class<?> type) {
		final ValidationConfig config = new ValidationConfig();
		config.constraintValidatorFactory(resourceContext.getResource(InjectingConstraintValidatorFactory.class));
		config.parameterNameProvider(new CustomParameterNameProvider());
		return config;
	}

	/**
	 * See ContactCardTest#testAddInvalidContact.
	 */
	private class CustomParameterNameProvider implements ParameterNameProvider {

		private final ParameterNameProvider nameProvider;

		public CustomParameterNameProvider() {
			nameProvider = Validation.byDefaultProvider().configure().getDefaultParameterNameProvider();
		}

		public List<String> getParameterNames(final Constructor<?> constructor) {
			return nameProvider.getParameterNames(constructor);
		}

		public List<String> getParameterNames(final Method method) {
			return nameProvider.getParameterNames(method);
		}
	}
}