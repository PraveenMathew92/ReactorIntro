package com.example.sample

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.*

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

    fun getEvents(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id")
        val events = Flux.generate<ShowEvent> { synchronousSink ->
            synchronousSink.next(ShowEvent(id, Date()))}.delayElements(Duration.ofSeconds(1))
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(events, ShowEvent::class.java)
    }

    fun post(serverRequest: ServerRequest): Mono<ServerResponse> {
        val show = serverRequest.bodyToMono(Show::class.java)
        show.map { showRepository.save(it) }
        return ServerResponse.status(201).build()
    }
}