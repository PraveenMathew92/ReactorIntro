package com.example.sample

import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import org.reactivestreams.Publisher
import org.springframework.data.domain.Example
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

@Repository
interface ShowRepository : ReactiveMongoRepository<Show, String>