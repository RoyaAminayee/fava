package com.test.cm2.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "institute")

public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_inst")
    @SequenceGenerator(name = "seq_inst", sequenceName = "seq_inst", allocationSize = 1)
    private Long id;


    @Column(name= "name", nullable = false)
    private String name;


    // Define the many-to-many relationship with City
    @ManyToMany
    @JoinTable(
            name = "institute_city",
            joinColumns = @JoinColumn(name = "institute_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private Set<City> cities = new HashSet<>();

}
