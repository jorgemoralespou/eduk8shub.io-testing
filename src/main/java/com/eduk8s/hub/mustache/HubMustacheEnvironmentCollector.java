package com.eduk8s.hub.mustache;

import com.samskivert.mustache.DefaultCollector;
import com.samskivert.mustache.Mustache.Collector;
import com.samskivert.mustache.Mustache.VariableFetcher;
import com.samskivert.mustache.Template;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

/**
 * Mustache {@link Collector} to expose properties from the Spring {@link Environment}.
 *
 * @author Dave Syer
 * @author Madhura Bhave
 * @since 1.2.2
 */
public class HubMustacheEnvironmentCollector extends DefaultCollector implements EnvironmentAware {

	private ConfigurableEnvironment environment;

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = (ConfigurableEnvironment) environment;
	}

	@Override
	public VariableFetcher createFetcher(Object ctx, String name) {
		VariableFetcher fetcher = super.createFetcher(ctx, name);
		if (fetcher != null) {
			return new PropertyVariableFetcher(fetcher);
		}
		if (this.environment.containsProperty(name)) {
			return new PropertyVariableFetcher();
		}
		return null;
	}

	private class PropertyVariableFetcher implements VariableFetcher {

		private final VariableFetcher nativeFetcher;

		PropertyVariableFetcher() {
			this.nativeFetcher = null;
		}

		PropertyVariableFetcher(VariableFetcher nativeFetcher) {
			this.nativeFetcher = nativeFetcher;
		}

		@Override
		public Object get(Object ctx, String name) {
			Object result;
			if (this.nativeFetcher != null) {
				try {
					result = this.nativeFetcher.get(ctx, name);
					if (result != null && result != Template.NO_FETCHER_FOUND) {
						return result;
					}
				}
				catch (Exception ex) {
					// fall through
				}
			}
			result = HubMustacheEnvironmentCollector.this.environment.getProperty(name);
			if (result == null) {
				return Template.NO_FETCHER_FOUND;
			}
			return result;
		}

	}

}