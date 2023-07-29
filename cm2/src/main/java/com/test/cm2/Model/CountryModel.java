package com.test.cm2.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "country")
public class CountryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_country")
    @SequenceGenerator(name = "seq_country", sequenceName = "seq_country", allocationSize = 1)
    private Long id;

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
    private List<StateModel> states;
}



