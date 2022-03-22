package com.sofkau.dojoreactor.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Email {

    public List<String> getEmails() {

        List<String> emails = List.of("juan@hotmail.com", "arturo@outlook.com", "juan@outlook.com", "armillia@sofka.com", "cirilla@gmail.com",
                "jinx@sofka.com", "albert@gmail.com", "dante@gmail.com", "wendy@gmail.com", "dennis@hotmail.com",
                "camila@outlook.com", "diane@hotmail.com", "camila@gmail.com", "staicy@hotmail.com", "dante@gmail.com",
                "jinx@sofka.com", "cirilla@gmail.com", "juan@gmail.com", "legend2123@gmail.com", "jaskier@sofka.com",
                "fenix@outlook.com", "lenin@hotmail.com", "justsad2@gmail.com", "armillia@gmail.com", "yennefer@gmail.com",
                "dante@gmail.com", "geralt@outlook.com", "justsad2@gmail.com", "cleopatra@sofka.com", "lilly@sofka.com");


        return emails;
    }

    //Correos repetidos
    public Flux<String> getEmailsNoRepeated(){
        return Flux.fromIterable(getEmails())
                .distinct();
    }

    public Mono<Long> countEmailsRepeated() {
        return Flux.fromIterable(getEmails())
                .distinct()
                .count();
    }

}
