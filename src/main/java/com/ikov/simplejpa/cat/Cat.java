package com.ikov.simplejpa.cat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ikov.simplejpa.owner.Owner;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    private int age;

    public Cat(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnoreProperties("cats")
    private Owner owner;
}
