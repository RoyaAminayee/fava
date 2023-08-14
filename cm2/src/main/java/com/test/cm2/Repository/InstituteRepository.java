package com.test.cm2.Repository;

import com.test.cm2.Model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//
//@Repository
//public interface InstituteRepository extends JpaRepository<Institute, Long>, JpaSpecificationExecutor<Institute> {
////    List<Institute> findInstitutesByCitiesID(Long inst_id);
//    List<Institute> findInstitutesByCities_IdIn(List<Long> cityIds);
//
//}

@Repository
public interface InstituteRepository extends JpaRepository<Institute, Long>, JpaSpecificationExecutor<Institute> {

//    @Query("SELECT i FROM Institute i JOIN i.cities c WHERE c.CityId IN :cityIds")
//    List<Institute> findInstitutesByCityIds(@Param("cityIds") List<Long> cityIds);
}
