package com.test.cm2.Repository;

import com.test.cm2.Model.City;
import com.test.cm2.Model.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {
}

