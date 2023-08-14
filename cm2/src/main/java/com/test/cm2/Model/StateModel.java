package com.test.cm2.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(name = "state")
public class StateModel {
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id")
    private CountryModel country;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_state")
    @SequenceGenerator(name = "seq_state", sequenceName = "seq_state", allocationSize = 1)
    private Long StateId;

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

}
