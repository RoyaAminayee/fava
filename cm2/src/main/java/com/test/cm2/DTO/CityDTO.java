package com.test.cm2.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CityDTO implements Serializable {
    private Long cityId;
    private Long stateId;
    private Long countryId;
    private String cityTitle;
    private String cityLatinTitle;
    private String cityDescription;
}

