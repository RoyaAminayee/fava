package com.test.cm2.Repository;

import com.test.cm2.Model.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface StateRepository extends JpaRepository<StateModel, Long>, JpaSpecificationExecutor<StateModel> {
    List<StateModel> findByCountryId(Long countryId);
}
