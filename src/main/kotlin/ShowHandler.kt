package com.example.sample

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class ShowHandler(private val showRepository: ShowRepository) {
    fun all(serverRequest: ServerRequest): Mono<ServerResponse> {
        val shows = showRepository.findAll()
        return ServerResponse.ok().body<Show, Flux<Show>>(shows, Show::class.java)
    }

    fun byId(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id")
        val show = showRepository.findById(id)
        return ServerResponse.ok().body(show, Show::class.java)
    }
}