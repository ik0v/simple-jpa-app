package com.ikov.simplejpa.cat.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ikov.simplejpa.owner.Owner;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Profile {

    @Id
    @GeneratedValue(generator = "profile_gen")
    @SequenceGenerator(name = "profile_gen", sequenceName = "profile_seq",  allocationSize = 1)  // default allocationSize = 51
    @Column(name = "profile_id")
    private Long id;
    @Column(name = "profile_language")
    private String language;
    @Column(name = "profile_timezone")
    private String tomeZone;

    @OneToOne
    @JoinColumn(name = "profile_owner_id")
    @JsonIgnoreProperties("profile")
    private Owner owner;

}
