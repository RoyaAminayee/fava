package com.test.cm2.Mapper.Repository;


import com.test.cm2.Model.CountryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
@EnableJpaAuditing
public interface CountryRepository extends JpaRepository<CountryModel, Long>, JpaSpecificationExecutor<CountryModel> , PagingAndSortingRepository<CountryModel, Long> {
//    Page<CountryModel> findAll(Pageable pageable);

}

