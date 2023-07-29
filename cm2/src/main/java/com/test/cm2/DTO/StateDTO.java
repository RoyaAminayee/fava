package com.test.cm2.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StateDTO implements Serializable {
    private Long stateId;
    private Long countryId;
    private String stateTitle;
    private String stateLatinTitle;
    private String stateDescription;
}

