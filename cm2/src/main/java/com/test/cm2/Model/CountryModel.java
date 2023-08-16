package com.test.cm2.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "country")
//@Audited
@EntityListeners(AuditingEntityListener.class)
public class CountryModel extends BaseEntity {

    @NonNull
    @Column(name = "title",nullable = false)
    private String title;

    @NonNull
    @Column(name = "latin_title",nullable = false)
    private String latinTitle;

    @NonNull
    @Column(name ="description",nullable = false)
    private String description;

//    @NonNull
//    @Column(name="is_active",nullable = false)
//    private Boolean isActive;
    @JsonManagedReference
    @OneToMany(mappedBy = "country")
    @NotAudited
    private List<StateModel> states;
}




