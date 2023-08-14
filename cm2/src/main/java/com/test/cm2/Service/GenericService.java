//package com.test.cm2.Service;
//
//import com.test.cm2.DTO.CountryDTO;
//import com.test.cm2.Mapper.CountryMapper;
//import com.test.cm2.Model.BaseEntity;
//import jakarta.persistence.EntityNotFoundException;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Service;
//import org.yaml.snakeyaml.events.Event;
//
//import java.util.List;
//
//@Service
////@Primary
////@RequiredArgsConstructor
////@AllArgsConstructor
//public class GenericService<T_model> {
//
////    @Autowired
////    private final GenericRepository<T ,Long> genericRepository;
//    private final JpaRepository<T_model, Long> repository;
//    public GenericService(JpaRepository<T_model, Long> repository) {
//        this.repository = repository;
//    }
//
//    //    @Autowired
////    private final JpaRepository<T_model, Long> repository;
////    private final CountryMapper countryMapper;
//
////    public T create(T entity) {
////        return genericRepository.save(entity);
////    }
////
////    public T getById(Long id) {
////        return genericRepository.findById(id)
////                .orElseThrow(() -> new EntityNotFoundException("Entity not found with ID: " + id));
////    }
//
//    public List<T_model> getAll() {
//        return repository.findAll();
//    }
//
////    public T update(Long id, T entity) {
////        T existingEntity = getById(id);
////        // Perform the update logic here with entity's fields
////        return genericRepository.save(existingEntity);
////    }
////
////    public void delete(Long id) {
////        if (!genericRepository.existsById(id)) {
////            throw new EntityNotFoundException("Entity not found with ID: " + id);
////        }
////        genericRepository.deleteById(id);
////    }
//
//
//
//}
