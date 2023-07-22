package com.test.cm2.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tbl_country", uniqueConstraints = @UniqueConstraint(name = "COUNTRY_UQ_TITLE", columnNames = "title"))
public class CountryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_country")
    @SequenceGenerator(name = "seq_country", sequenceName = "seq_country", allocationSize = 1)
    private Long id;

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
    private boolean isActive;
}
