package com.ikov.simplejpa.owner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ikov.simplejpa.cat.Cat;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fName;

    public Owner(String fName, String lName, String email) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    private String lName;
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("owner")
    private Set<Cat> cats;

}
