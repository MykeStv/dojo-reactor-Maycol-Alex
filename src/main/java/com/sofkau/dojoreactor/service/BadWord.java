package com.sofkau.dojoreactor.service;

import io.netty.util.internal.StringUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;

public class BadWord {

    private List<String> badWords = List.of("puta", "gonorrea", "marica", "mierda", "imbecil",
            "malparido", "pirobo", "huevon", "cacorro", "cagar");

    public Mono<String> correctorWords(String phrase) {
        List<String> wordPhrase = List.of(phrase.split(" "));


        /*Flux<String> fx = Flux.fromIterable(badWords)
                .map(w -> {
                    if (phrase.contains(w)) {
                        phrase.replace(w, "****");
                    }
                    return w;
                });*/


         Mono<String> mono = Flux.fromIterable(wordPhrase)
                .map(w -> (badWords.contains(w)) ? "****" : w)
                .collect(joining(" "));

        return mono;


    }

}
