package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {

        // use just only when you have data already
//         Mono<String> mono1 = Mono.just(getName()); // Creating Mono using just

        // Creating a Mono using supplier or callable
        // 1) Using Supplier creating the Mono and then subscribing
        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(  // without calling subscribe method getName() will not be invoked.
                Util.onNext()
        );
        // 2) Alternate way: Using Callable interface
        // Any lambda expression that returns a value can be assigned to functional interface like Supplier or Callable
        // Both Supplier and Callable have abstract methods that return something
        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext()
                );
    }

    private static String getName() {
        System.out.println("Generating name..");
        return Util.faker().name().fullName();
    }

}
