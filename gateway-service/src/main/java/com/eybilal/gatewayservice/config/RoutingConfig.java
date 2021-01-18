package com.eybilal.gatewayservice.config;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {
    @Bean
    DiscoveryClientRouteDefinitionLocator dynamicRoutes(
        ReactiveDiscoveryClient reactiveDiscoveryClient,
        DiscoveryLocatorProperties discoveryLocatorProperties
    ) {
        return new DiscoveryClientRouteDefinitionLocator(
            reactiveDiscoveryClient,
            discoveryLocatorProperties
        );
    }

    @Bean
    RouteLocator staticRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                                    .route(route -> route.path("/countries/**")
                                        .filters(filter ->
                                            filter.addRequestHeader(
                                                    "x-rapidapi-key",
                                                    ""			// TODO RAPID_API_KEY from .env file
                                            ).addRequestHeader(
                                                    "x-rapidapi-host",
                                                    "restcountries-v1.p.rapidapi.com"
                                            ).rewritePath(
                                                    "/countries/(?<segment>.*)","/${segment}"
                                            ) // If the rest is not available or not reachable
                                            .hystrix(h ->
                                                h.setName("countries")
                                                 .setFallbackUri("forward:/countries/default")
                                            )
                                        ).uri("https://restcountries-v1.p.rapidapi.com").id("countries")
                                    ).build();

    }
}
