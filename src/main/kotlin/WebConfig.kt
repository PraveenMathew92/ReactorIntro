package com.example.sample

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicate

@Configuration
@EnableWebFlux
class WebConfig : WebFluxConfigurer {
    @Bean
    fun routeShow(showHandler: ShowHandler): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route(RequestPredicates.GET("/shows"), HandlerFunction<ServerResponse> { showHandler.all(it) })
            .andRoute(RequestPredicates.GET("/show/{id}"), HandlerFunction<ServerResponse> { showHandler.byId(it) })
            .andRoute(RequestPredicates.GET("/events/{id}"), HandlerFunction<ServerResponse> { showHandler.getEvents(it) })
    }
}