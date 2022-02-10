package com.ttl.springboot1.SpringBootFullStackApplication1;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("Configure method called");
		return application.sources(SpringBootFullStackApplication1Application.class);
	}

}
