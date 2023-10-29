package com.cavm.elecciones.escolares;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class MvcConfig {
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error_403").setViewName("error_403");
	}
}
