package com.ikov.simplejpa.owner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<Owner>> getOwners() {
        List<Owner> owners = ownerService.getOwners();
//        return ResponseEntity.ok(cats);
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable long id) {
        Owner owner = ownerService.getOwnerById(id);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        return new ResponseEntity<>(ownerService.addOwner(owner), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable long id) {
        ownerService.deleteOwnerById(id);
        return new ResponseEntity<>("Owner is deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable long id, @RequestBody Owner owner) {
        Owner updatedOwner = ownerService.updateOwner(id, owner);
        return new ResponseEntity<>(updatedOwner, HttpStatus.OK);
    }

}
