package com.test.cm2.Mapper.Repository;

import com.test.cm2.Model.City;
import com.test.cm2.Model.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {
    @Query("select c from City c where c.id in :ids")
    Set<City> findAllByIds(Set<Long> ids);

    @Query("select c from City c where c.id = :id")
    Void findCityById(Long id);
}

