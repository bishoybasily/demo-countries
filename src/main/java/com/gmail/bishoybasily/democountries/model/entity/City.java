package com.gmail.bishoybasily.democountries.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)
@Entity(name = "city")
public class City {

    @Id
    private Integer id;

    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_code")
    private Country country;


}
