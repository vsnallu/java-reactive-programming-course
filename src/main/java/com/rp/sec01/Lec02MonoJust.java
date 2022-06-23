package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just(1);
        System.out.println(mono);
        // Nothing happens until you subscribe in reactive programming.
        // Here we are passing a consumer (lambda expression) to the subscribe method and asking publisher to emit the data
        mono.subscribe(i -> System.out.println("Received : " + i)); // Here onNext method of subscriber will be called

    }

}
