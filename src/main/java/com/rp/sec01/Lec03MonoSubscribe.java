package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 1);

        // 1
        // mono.subscribe();

//        mono.subscribe(item -> System.out.println(item),
//                err-> System.out.println(err.getMessage()),
//                () -> System.out.println("Completed"));
        // 2
        mono.subscribe(
                Util.onNext(), // Look at onNext(), onError(), onComplete() methods defined in courseutil.Util
                Util.onError(), // provide the behavior in case of error. For example, if we divide by zero in the above map,only onError will be called
                Util.onComplete()
        );
    }

}
