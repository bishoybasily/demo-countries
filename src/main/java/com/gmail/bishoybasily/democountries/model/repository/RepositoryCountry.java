package com.gmail.bishoybasily.democountries.model.repository;

import com.gmail.bishoybasily.democountries.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCountry extends JpaRepository<Country, String> {
}
