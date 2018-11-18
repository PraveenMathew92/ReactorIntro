package com.example.sample

import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import org.reactivestreams.Publisher
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

@Repository
class ShowRepository(val showsMap: Map<String, Show> = mapOf<String, Show>(Pair("1", Show("1", "Title1")),
        Pair("2", Show("2", "Title2")), Pair("3", Show("3", "Title3")),
        Pair("4", Show("4", "Title4")))): ReactiveCrudRepository<Show, String> {

    override fun <S : Show> save(s: S): Mono<S> {
        return Mono.empty()
    }

    override fun <S : Show> saveAll(iterable: Iterable<S>): Flux<S> {
        return Flux.empty()
    }

    override fun <S : Show> saveAll(publisher: Publisher<S>): Flux<S> {
        return Flux.empty()
    }

    override fun findById(s: String): Mono<Show> {
        return Mono.empty()
    }

    override fun findById(publisher: Publisher<String>): Mono<Show> {
        return Mono.empty()
    }

    override fun existsById(s: String): Mono<Boolean> {
        return Mono.empty()
    }

    override fun existsById(publisher: Publisher<String>): Mono<Boolean> {
        return Mono.empty()
    }

    override fun findAll(): Flux<Show> {
        return Flux.fromIterable(showsMap.values)
    }

    override fun findAllById(iterable: Iterable<String>): Flux<Show> {
        return Flux.empty()
    }

    override fun findAllById(publisher: Publisher<String>): Flux<Show> {
        return Flux.empty()
    }

    override fun count(): Mono<Long> {
        return Mono.empty()
    }

    override fun deleteById(s: String): Mono<Void> {
        return Mono.empty()
    }

    override fun deleteById(publisher: Publisher<String>): Mono<Void> {
        return Mono.empty()
    }

    override fun delete(show: Show): Mono<Void> {
        return Mono.empty()
    }

    override fun deleteAll(iterable: Iterable<Show>): Mono<Void> {
        return Mono.empty()
    }

    override fun deleteAll(publisher: Publisher<out Show>): Mono<Void> {
        return Mono.empty()
    }

    override fun deleteAll(): Mono<Void> {
        return Mono.empty()
    }
}