package ru.gsmirnov.police.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Enables filters. It connects DelegatingFilterProxy - the main filter, who handles the requests.
 * Tomcat automatic detects it and enables.
 *
 * @author Gregory Smirnov (gsmirnov <gsmirnov@callinsight.ru>)
 * @version 0.1
 * @since 2020-06-11
 */
public class SecurityInit extends AbstractSecurityWebApplicationInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(SecurityInit.class);
}
