package com.ikov.simplejpa.cat;

import com.ikov.simplejpa.owner.Owner;
import com.ikov.simplejpa.owner.OwnerRepo;
import com.ikov.simplejpa.owner.OwnerService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatService {

    private final CatRepo catRepo;
    private final OwnerService ownerService;

    public CatService(CatRepo catRepo, OwnerRepo ownerRepo, OwnerService ownerService) {
        this.catRepo = catRepo;
        this.ownerService = ownerService;
    }

    public List<Cat> getCats() {
        return catRepo.findAll();
    }

    public List<Cat> getCatsBelowAge(int age) {
        return catRepo.findCatsByAgeBefore(age);
    }

    public Cat getCatByUd(long id) {
        return catRepo.findById(id).orElse(null);
    }

    public Cat addCat(Cat cat) {
        return catRepo.save(cat);
    }

//    public Cat addCat(CatDto catDto) {
//        Owner owner = ownerService.getOwnerById()
//        return catRepo.save(cat);
//    }

    public void deleteCat(long id) {
        catRepo.deleteById(id);
    }

    public Cat updateCat(long id, Cat cat) {
        Cat catToUpdate = catRepo.findById(id).orElse(null);
        if(catToUpdate == null) return null;
        catToUpdate.setName(cat.getName());
        catToUpdate.setAge(cat.getAge());
        catToUpdate.setOwner(cat.getOwner());
        return catRepo.save(cat);
    }

}
