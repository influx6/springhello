package com.in28minutes.rest.webservices.restful.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.hateoas.mediatype.hal.HalLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.*;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Alexander Ewetumo", "http://github.com/influx6", "trinoxf@gmail.com");
	public static final ApiInfo API_INFO = new ApiInfo(
			"Hello Spring API Documentation", "Spring Restful Service Documentation", "1.0",
			"urn:tos", DEFAULT_CONTACT.toString(), "Apache 2.0",
			"http://www.apache.org/licenses/LICENSE-2.0"
	);
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMERS = new HashSet<String>(Arrays.asList("application/json", "application/xml"));

	@Bean
	public LinkDiscoverers discoverers() {
		List<LinkDiscoverer> plugins = new ArrayList<LinkDiscoverer>();
		plugins.add(new CollectionJsonLinkDiscoverer());
		plugins.add(new HalLinkDiscoverer());
		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMERS)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMERS)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();

	}
}
