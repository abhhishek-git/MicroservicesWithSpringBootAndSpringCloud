package com.in28minutes.rest.webservices.restfulwebserviecs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;

import com.google.common.net.MediaType;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Configuration
@Configuration
//Enable Swagger
@EnableSwagger2
public class SwaggerConfig {
	//Bean - Docket
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
	

	@Bean
	public LinkDiscoverers discoverers() {
	    List<LinkDiscoverer> plugins = new ArrayList<>();
	    plugins.add(new CollectionJsonLinkDiscoverer());
	    return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
	}
	
	//Swagger2
	//All the paths
	//All the APIs
}
