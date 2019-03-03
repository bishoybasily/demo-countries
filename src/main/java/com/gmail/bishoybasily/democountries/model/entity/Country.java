package com.gmail.bishoybasily.democountries.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "code")
@Accessors(chain = true)
@Entity(name = "country")
public class Country {

    @Id
    @JsonProperty("country_code")
    private String code;

    private String name;

    private String region;

    private String continent;

    private Long population;

    @JsonProperty("life_expectancy")
    private String lifeExpectancy;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private Set<City> cities = new HashSet<>();
}
