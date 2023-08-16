package com.test.cm2.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class CountryDTO extends BaseDTO implements Serializable {

    private String title;
    private String latinTitle;
    private String description;
}
