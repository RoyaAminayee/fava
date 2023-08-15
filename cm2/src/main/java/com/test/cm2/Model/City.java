package com.test.cm2.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_city")
    @SequenceGenerator(name = "seq_city", sequenceName = "seq_city", allocationSize = 1)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryModel country;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateModel state;

    @NonNull
    @Column(nullable = false)
    private String Title;

    @NonNull
    @Column(nullable = false)
    private String latinTitle;

    @NonNull
    @Column(nullable = false)
    private String Description;

    @NonNull
    @Column(nullable = false)
    private Boolean isActive;

    @ManyToMany(mappedBy = "cities")
    private Set<Institute> institutes;

}

