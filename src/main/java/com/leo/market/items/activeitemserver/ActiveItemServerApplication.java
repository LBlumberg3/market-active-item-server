package com.leo.market.items.activeitemserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ActiveItemServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ActiveItemServerApplication.class, args);
    }

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(application.getClass());
	}

}
