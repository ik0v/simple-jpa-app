package com.ikov.simplejpa.cat.profile;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepo repo;

    public ProfileService(ProfileRepo repo) {
        this.repo = repo;
    }

    public List<Profile> getProfiles() {
        return repo.findAll();
    }

    public Profile getProfileById(long id) {
        return repo.findById(id).orElse(null);
    }

    public Profile saveProfile(Profile profile) {
        return repo.save(profile);
    }

    public void deleteProfileById(long id) {
        repo.deleteById(id);
    }


}
