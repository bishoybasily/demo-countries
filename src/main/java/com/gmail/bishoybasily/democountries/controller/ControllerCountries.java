package com.gmail.bishoybasily.democountries.controller;

import com.gmail.bishoybasily.democountries.model.entity.Country;
import com.gmail.bishoybasily.democountries.model.service.ServiceCountries;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/countries")
public class ControllerCountries {

    private ServiceCountries serviceCountries;

    public ControllerCountries(ServiceCountries serviceCountries) {
        this.serviceCountries = serviceCountries;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Country> findAll() {
        return serviceCountries.findAll();
    }

    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Country> findOne(@PathVariable String code) {
        return serviceCountries.findOne(code);
    }
}
