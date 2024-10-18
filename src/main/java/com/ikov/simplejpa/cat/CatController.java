package com.ikov.simplejpa.cat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public ResponseEntity<List<Cat>> getCats() {
        List<Cat> cats = catService.getCats();
//        return ResponseEntity.ok(cats);
        return new ResponseEntity<>(cats, HttpStatus.OK);
    }

    @GetMapping("age/{age}")
    public ResponseEntity<List<Cat>> getCatsBelowAge(@PathVariable int age) {
        List<Cat> cats = catService.getCatsBelowAge(age);
//        return ResponseEntity.ok(cats);
        return new ResponseEntity<>(cats, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cat> getCat(@PathVariable long id) {
        Cat cat = catService.getCatByUd(id);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cat> createCat(@RequestBody Cat cat) {
        return new ResponseEntity<>(catService.addCat(cat), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCat(@PathVariable long id) {
        catService.deleteCat(id);
        return new ResponseEntity<>("Your cat is deleteed", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCat(@PathVariable long id, @RequestBody Cat cat) {
        catService.updateCat(id, cat);
        return new ResponseEntity<>("Your cat is deleteed", HttpStatus.OK);
    }



}
