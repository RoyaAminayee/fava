package com.test.cm2.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.List;

@Entity
@Data
@Table(name = "country")
@NoArgsConstructor
@Audited
@EntityListeners(AuditingEntityListener.class)
public class CountryModel extends BaseEntity {

    @NonNull
    @Column(name = "title")
    private String title;

    @NonNull
    @Column(name = "latin_title")
    private String latinTitle;

    @NonNull
    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "is_active")
    private Boolean isActive;

    @NotAudited
    @JsonManagedReference
    @OneToMany(mappedBy = "country")
    private List<StateModel> states;
}




