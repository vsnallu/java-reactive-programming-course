package com.rp.sec01;

import java.util.stream.Stream;

public class Lec01Stream {

    // Stream lazy behavior. Without terminal operation like forEach, the stream will not be processed.
    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1)
                .map(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i * 2;
                });

//        System.out.println(stream);
        stream.forEach(System.out::println);
//        stream.forEach(i -> System.out.println(i)); // Will throw Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed if uncommented
    }


}
