package com.ikov.simplejpa;

import com.github.javafaker.Faker;
import com.ikov.simplejpa.cat.Cat;
import com.ikov.simplejpa.cat.CatService;
import com.ikov.simplejpa.owner.Owner;
import com.ikov.simplejpa.owner.OwnerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InitialData implements CommandLineRunner {

    private final CatService catService;
    private final OwnerService ownerService;
    private final Random rand = new Random();
    private final Faker faker;

    public InitialData(CatService catService, OwnerService ownerService) {
        this.catService = catService;
        this.ownerService = ownerService;
        this.faker = Faker.instance();
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 25; i++) {
            Owner owner = ownerService.addOwner(new Owner(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.internet().emailAddress()
            ));
            Set<Cat> cats = new HashSet<>();

            for (int j = 0; j < rand.nextInt(1,4) ; j++) {
                Cat cat = catService.addCat(new Cat(
                        faker.cat().name(),
                        faker.cat().breed(),
                        new Random().nextInt(1, 18)
                ));
                cat.setOwner(owner);
                cats.add(cat);
                catService.updateCat(cat.getId(), cat);
            }
            owner.setCats(cats);
            ownerService.updateOwner(owner.getId(), owner);
        }
    }
}

