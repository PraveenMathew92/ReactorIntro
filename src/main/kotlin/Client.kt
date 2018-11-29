package com.example.sample

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.lang.Math.random

class Client {
    val webClient = WebClient.create("localhost:8080")

    fun addAShow(){
        val showId = random().toString()
        val response = webClient
            .post()
            .uri("show/add")
            .body(Mono.just(Show(showId, "Show Name".plus(showId))), Show::class.java)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
        response.map { println(it.statusCode()) }
    }

    fun displayEvent(){
        val showId = random().toString()
        val response = webClient
            .get()
            .uri("/shows")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
        response.flatMap{ it.bodyToMono(Show::class.java)}
            .subscribe{ print(it) }
    }
}