package com.test.cm2.Mapper.Repository;

import com.test.cm2.Model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface inst_cityRepo  extends JpaRepository<Institute, Long>, JpaSpecificationExecutor<Institute> {

//    @Query("SELECT i FROM Institute i JOIN i.cities c WHERE c.CityId IN :cityIds")
//    List<Institute> findInstitutesByCityIds(@Param("cityIds") List<Long> cityIds);
}
