package com.ikov.simplejpa;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fName;
    private String lName;

    @OneToMany
    private Set<Cat> cats;

}
