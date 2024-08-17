package br.com.lucas.testeapi.utils;

import org.awaitility.Awaitility;

import java.time.Duration;
import java.util.concurrent.Callable;

public class Await {

    public static void await(Callable<Boolean> expression) {
        Awaitility.await().atMost(Duration.ofSeconds(30))
                .pollInterval(Duration.ofSeconds(1))
                .until(expression);
    }
}
