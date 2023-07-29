package com.test.cm2.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CountryDTO implements Serializable {

    private Long id;
    private String title;
    private String latinTitle;
    private String description;
//    private Boolean isActive;
}
