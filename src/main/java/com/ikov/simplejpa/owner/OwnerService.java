package com.ikov.simplejpa.owner;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepo repo;

    public OwnerService(OwnerRepo repo) {
        this.repo = repo;
    }

    public List<Owner> getOwners() {
        return repo.findAll();
    }

    public Owner getOwnerById(long id) {
        return repo.findById(id).orElse(null);
    }

    public Owner addOwner(Owner owner) {
        return repo.save(owner);
    }

    public void deleteOwnerById(long id) {
        repo.deleteById(id);
    }

    public Owner updateOwner(long id, Owner updatedOwner) {
        Owner owner = repo.findById(id).orElse(null);
        if (owner == null) return owner;
        owner.setFName(updatedOwner.getFName());
        owner.setLName(updatedOwner.getLName());
        owner.setEmail(updatedOwner.getEmail());
        return repo.save(owner);
    }
}
