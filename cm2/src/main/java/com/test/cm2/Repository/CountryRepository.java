package com.test.cm2.Repository;


import com.test.cm2.Model.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryModel, Long>, JpaSpecificationExecutor<CountryModel> {
}

