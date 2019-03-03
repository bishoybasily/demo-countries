package com.gmail.bishoybasily.democountries.model.service;


import com.gmail.bishoybasily.democountries.model.entity.Country;
import com.gmail.bishoybasily.democountries.model.exception.ExceptionNotFound;
import com.gmail.bishoybasily.democountries.model.repository.RepositoryCountry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceCountriesTest {

    @Autowired
    private RepositoryCountry repositoryCountry;
    @Autowired
    private ServiceCountries serviceCountries;

    @Before
    public void setUp() throws Exception {
        repositoryCountry.deleteAll();
    }

    @After
    public void tearDown() throws Exception {
        repositoryCountry.deleteAll();
    }

    @Test
    public void findAll() {

        // verify empty response
        StepVerifier.create(serviceCountries.findAll())
                .verifyComplete();

        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            countries.add(new Country().setCode("code_" + i).setName("name_" + i));
        repositoryCountry.saveAll(countries);

        int index = -1;

        // verify three entries
        StepVerifier.create(serviceCountries.findAll())
                .expectNext(countries.get(++index))
                .expectNext(countries.get(++index))
                .expectNext(countries.get(++index))
                .verifyComplete();

    }

    @Test
    public void findOne() {

        String code = "unknown_code";

        // verify not found exception
        StepVerifier.create(serviceCountries.findOne(code))
                .verifyError(ExceptionNotFound.class);

        Country country = new Country().setCode(code);
        repositoryCountry.save(country);

        // verify single entry
        StepVerifier.create(serviceCountries.findOne(code))
                .expectNext(country)
                .verifyComplete();

    }
}
