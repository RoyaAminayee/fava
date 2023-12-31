package com.test.cm2.DTO.Service;

import com.test.cm2.DTO.CountryDTO;
import com.test.cm2.Exception.ExceptionHandlers;
import com.test.cm2.Mapper.CountryMapper;
import com.test.cm2.Model.CountryModel;
import com.test.cm2.Mapper.Repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

//
//
@Service
@RequiredArgsConstructor
//public class CountryService extends GenericService<CountryDTO,Long> {
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;
//    private final GenericService genericService;


    public List<CountryModel> getCountriesByCriteria(String fieldName, String operator, String value) {
        Specification<CountryModel> spec = (root, query, criteriaBuilder) -> {
            if (operator.equals("equal")) {
                return criteriaBuilder.equal(root.get(fieldName), value);
            } else if (operator.equals("contains")) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get(fieldName)), "%" + value.toLowerCase() + "%");
            }
            return null;
        };
        return countryRepository.findAll(spec);
    }

//    Specification<Product> nameLike =
//            (root, query, criteriaBuilder) ->
//                    criteriaBuilder.like(root.get(Product_.NAME), "%"+name+"%");


    public CountryDTO getCountryById(Long id) {
        CountryModel countryModel = countryRepository.findById(id).orElseThrow(() -> new ExceptionHandlers.EntityNotFoundException("Country not found with ID: " + id));
        return countryMapper.toDTO(countryModel);
    }

    public CountryDTO createCountry(CountryDTO countryDTO) {
        CountryModel entity= countryMapper.toEntity(countryDTO);

        if (countryRepository.findById(entity.getId()).isPresent()) {
            throw new ExceptionHandlers.DuplicateError("Entity with name " + entity.getTitle() + " already exists");
        }

        CountryModel countryModel = countryMapper.toEntity(countryDTO);
        CountryModel savedCountry = countryRepository.save(countryModel);
        return countryMapper.toDTO(savedCountry);
    }

    public void deleteCountry(Long id) {
        if (!countryRepository.existsById(id)) {
            throw new ExceptionHandlers.EntityNotFoundException("Country not found with ID: " + id);
        }

        if (!countryRepository.findAll().isEmpty()) {
            throw new ExceptionHandlers.RelatedEntityError(" relation cant be deleted");
        }

    }

    public Page<CountryDTO> getAllCountries(Pageable pageable) {
        Page<CountryModel> countryPage = countryRepository.findAll(pageable);
        return countryPage.map(countryMapper::toDTO);
    }

    //
    public List<CountryDTO> getAllCountries() {
        List<CountryModel> countryModels = countryRepository.findAll();
//        return countryModels;
        return countryMapper.toDTOList(countryModels);
//        List<CountryDTO> testc = new ArrayList<>();
//        testc.add(new CountryDTO(1,"a","aa","aaa"));
//        testc.add(new CountryDTO(2,"b","bb","bbb"));
//        testc.add(new CountryDTO(3,"c","cc","ccc"));
//        testc.add(new CountryDTO(4,"d","da","123"));
//        return testc;
//        return null;
    }


//    public CountryDTO updateCountry(Long id, CountryDTO countryDTO) {
//        CountryModel countryModel = countryRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Country not found with ID: " + id));


//        countryRepository.save(countryModel);
//        return countryDTO;
//    }

    public CountryDTO updateCountry(Long id, CountryDTO countryDTO) {
        CountryModel countryModel = countryRepository.findById(id).orElseThrow(() -> new ExceptionHandlers.EntityNotFoundException("Country not found with ID: " + id));

        // Update the fields of the countryModel with the fields from countryDTO

        countryRepository.save(countryModel);
        return countryDTO;
    }


}
