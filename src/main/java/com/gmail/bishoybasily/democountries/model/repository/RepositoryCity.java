package com.gmail.bishoybasily.democountries.model.repository;

import com.gmail.bishoybasily.democountries.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCity extends JpaRepository<City, Integer> {
}
