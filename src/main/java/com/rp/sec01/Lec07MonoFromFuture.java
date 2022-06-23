package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {

    public static void main(String[] args) {

        Mono.fromFuture(getName())
                .subscribe(Util.onNext());

        Util.sleepSeconds(1);

    }
    // CompletableFuture: A Future that may be explicitly completed (setting its value and status),
    // and mya be used as a CompletionStage, supporting dependent functions and actions that trigger upon its completion
    private static CompletableFuture<String> getName(){ // CompletableFuture is Java equivalent of Javascript Future
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }


}
