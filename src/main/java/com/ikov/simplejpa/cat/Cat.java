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
    @GeneratedValue(generator = "cat_gen")
    @SequenceGenerator(name = "cat_gen", sequenceName = "cat_seq", allocationSize = 1)
    @Column(name = "cat_id")
    private Long id;
    @Column(name = "cat_name")
    private String name;
    @Column(name = "cat_breed")
    private String breed;
    @Column(name = "cat_age")
    private int age;

    public Cat(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    @ManyToOne
    @JoinColumn(name = "cat_owner_id")
    @JsonIgnoreProperties("cats")
    private Owner owner;
}
