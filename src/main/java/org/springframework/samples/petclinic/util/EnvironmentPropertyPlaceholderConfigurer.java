package org.springframework.samples.petclinic.util;

import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.StringUtils;

public class EnvironmentPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private static final String ENVIRONMENT_NAME = "targetEnvironment";

    private String environment;

    public EnvironmentPropertyPlaceholderConfigurer() {
        super();
        String env = resolveSystemProperty(ENVIRONMENT_NAME);
        if (!StringUtils.isEmpty(env)) {
            environment = env;
        }
    }

    @Override
    protected String resolvePlaceholder(String placeholder, Properties props) {
        if (environment != null) {
            String value = props.getProperty(String.format("%s.%s", environment, placeholder));
            if (value != null) {
                return value;
            }
        }
        return super.resolvePlaceholder(placeholder, props);
    }

}
