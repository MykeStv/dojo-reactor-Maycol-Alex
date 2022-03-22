package com.sofkau.dojoreactor.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Email {

    public List<String> getEmails() {

        List<String> emails = List.of("juan@hotmail.com", "arturo@out.com", "juanoutlook.com", "armillia@sofka.com", "cirilla@gmail.com",
                "jinx@sofka.com", "albert@gmail.com", "dante@gmail.com", "wendy@gmail.com", "dennis@hotmail.com",
                "camila@outlook.com", "dianehotmail.com", "camila@gmail.com", "staicy@hotmail.com", "dante@gmail.com",
                "jinx@sofka.com", "cirilla@gmail.com", "juangmail.com", "legend2123@gmail", "jaskier@sofka.com",
                "fenix@outlook.com", "lenin@hotmail.com", "justsad2@gmail.com", "armillia@gmail.com", "yennefer@gmail.com",
                "dante@gmail.com", "geraltoutlook.com", "justsad2@gmail.com", "cleopatra@sofka.com", "lilly@.com");


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

    //CORREOS POR DOMINIO
    public Flux<String> getEmailsByDomain(String domain) {
        return Flux.fromIterable(getEmails())
                .filter(e -> e.contains(domain));
    }

    //CORREOS CUMPLEN CON MAP
    public Flux<String> getEmailsValids() {

        //Function<Flux<String>, Flux<String>> mapData;

        return Flux.fromIterable(getEmails())
                .map(e -> (e.contains("@") && e.contains("gmail.com")) ? e : e + ": no valid");

    }

}
