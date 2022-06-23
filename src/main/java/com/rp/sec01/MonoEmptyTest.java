package com.rp.sec01;

import reactor.core.publisher.Mono;

public class MonoEmptyTest {

    public static void main(String[] args) {
        getNumber()
                .subscribe((i) -> System.out.println("Received: " + i),
                        err-> System.out.println("Got Error: " + err.getMessage()),
                        () -> System.out.println("Completed"));
    }


    static Mono<Integer> getNumber() {
        return Mono.empty();
    }
}
