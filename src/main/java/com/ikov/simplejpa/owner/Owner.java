package com.ikov.simplejpa.owner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ikov.simplejpa.cat.Cat;
import com.ikov.simplejpa.cat.profile.Profile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(generator = "owner_gen")
    @SequenceGenerator(name = "owner_gen", sequenceName = "owner_seq", allocationSize = 1)
    @Column(name = "owner_id")
    private Long id;
    @Column(name = "owner_first_name")
    private String fName;

    public Owner(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    @Column(name = "owner_last_name")
    private String lName;
    @Column(name = "owner_email")
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("owner")
    private Set<Cat> cats;

    @OneToOne(mappedBy = "owner")
    @JsonIgnoreProperties("owner")
    private Profile profile;

}
