package com.ikov.simplejpa;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class InitialData implements CommandLineRunner {

    private final CatService catService;
    private final Faker faker;

    public InitialData(CatService catService) {
        this.catService = catService;
        this.faker = Faker.instance();
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 25; i++) {
            catService.addCat(new Cat(
                    faker.cat().name(),
                    faker.cat().breed(),
                    new Random().nextInt(1, 18)
            ));
        }

    }
}
