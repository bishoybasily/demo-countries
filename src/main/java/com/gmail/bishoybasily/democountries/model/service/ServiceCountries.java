package com.gmail.bishoybasily.democountries.model.service;

import com.gmail.bishoybasily.democountries.model.entity.Country;
import com.gmail.bishoybasily.democountries.model.exception.ExceptionNotFound;
import com.gmail.bishoybasily.democountries.model.repository.RepositoryCountry;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceCountries {

    private RepositoryCountry repositoryCountry;

    public ServiceCountries(RepositoryCountry repositoryCountry) {
        this.repositoryCountry = repositoryCountry;
    }

    public Flux<Country> findAll() {
        return Mono.fromCallable(() -> repositoryCountry.findAll()).flatMapMany(Flux::fromIterable);
    }

    public Mono<Country> findOne(String code) {
        return Mono.fromCallable(() -> repositoryCountry.findById(code).orElseThrow(ExceptionNotFound::new));
    }
}
