package com.example.sample

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class ShowHandler(private val showRepository: ShowRepository) {
    fun all(serverRequest: ServerRequest): Mono<ServerResponse> {
        val shows = this.showRepository.findAll()
        return ServerResponse.ok().body<Show, Flux<Show>>(shows, Show::class.java)
    }
}