package com.ikov.simplejpa;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatService {

    CatRepo catRepo;

    public CatService(CatRepo catRepo) {
        this.catRepo = catRepo;
    }

    public List<Cat> getCats() {
        return catRepo.findAll();
    }

    public Cat getCatByUd(long id) {
        return catRepo.findById(id).orElse(null);
    }

    public Cat addCat(Cat cat) {
        return catRepo.save(cat);
    }

    public void deleteCat(long id) {
        catRepo.deleteById(id);
    }

    public Cat updateCat(long id, Cat cat) {
        Cat catToUpdate = catRepo.findById(id).orElse(null);
        catToUpdate.setName(cat.getName());
        catToUpdate.setAge(cat.getAge());
        return catRepo.save(cat);
    }

}
