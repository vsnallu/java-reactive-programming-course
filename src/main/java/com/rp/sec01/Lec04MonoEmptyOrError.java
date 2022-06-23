package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

    public static void main(String[] args) {

        userRepository(4) // when you supply 2, directly onComplete will be called, since it is returning empty. For 4, it will call onError
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
//                        System.out::println,
//                        err -> System.out.println("error occured: " + err.getMessage()),
//                        () -> System.out.println("Completed")
                );

    }


    private static Mono<String> userRepository(int userId) {
        // 1
        if (userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty(); // null
        } else
            return Mono.error(new RuntimeException("Not in the allowed range"));
    }

}
