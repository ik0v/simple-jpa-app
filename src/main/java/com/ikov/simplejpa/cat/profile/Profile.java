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
    @GeneratedValue
    private Long id;
    private String language;
    private String tomeZone;

    @OneToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnoreProperties("profile")
    private Owner owner;

}
