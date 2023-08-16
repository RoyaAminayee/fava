package com.test.cm2.DTO;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
public class BaseDTO {

    private  Long id;

    private Integer version;

    private Date created;

    private String createdBy;

    private Date lastModifiedDate;

    private String lastModifiedBy;


}
