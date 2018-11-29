package com.example.sample

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import org.springframework.web.reactive.function.server.RequestPredicates.contentType

@Configuration
@EnableWebFlux
class WebConfig : WebFluxConfigurer {
    @Bean
    fun routeShow(showHandler: ShowHandler): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route(RequestPredicates.GET("/shows"), HandlerFunction<ServerResponse> { showHandler.all(it) })
            .andRoute(RequestPredicates.GET("/show/{id}"), HandlerFunction<ServerResponse> { showHandler.byId(it) })
            .andRoute(RequestPredicates.GET("/events/{id}"), HandlerFunction<ServerResponse> { showHandler.getEvents(it) })
            .andRoute(RequestPredicates.POST("/show/add").and(accept(MediaType.APPLICATION_JSON)).and(contentType(
                MediaType.APPLICATION_JSON)), HandlerFunction<ServerResponse> { showHandler.post(it)})
    }
}