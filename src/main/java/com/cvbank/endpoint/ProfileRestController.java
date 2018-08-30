package com.cvbank.endpoint;

import com.cvbank.error.ResourceNotFoundException;
import com.cvbank.model.Profile;
import com.cvbank.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProfileRestController {


    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/profiles")
    public List<Profile> getAllProfiles() {

        return profileRepository.findAll();

    }

    @GetMapping("/profiles/{id}")
    public Profile getProfile(@PathVariable Long id) {

        Optional<Profile> profile = profileRepository.findById(id);

        if (!profile.isPresent()) {
            throw new ResourceNotFoundException(Profile.class.getSimpleName() + " id not found - " + id);
        }
        return profile.get();
    }

    @PostMapping("/profiles")
    @Transactional
    public ResponseEntity<?> createNewProfile(@RequestBody Profile profile) {

        profileRepository.save(profile);
        return new ResponseEntity<>("New " + Profile.class.getSimpleName() + " " + profile.getFirstName() + " has been created", HttpStatus.CREATED);
    }

    @PutMapping("/profiles/{id}")
    @Transactional
    public ResponseEntity<?> updateProfile(@RequestBody Profile profile, @PathVariable Long id) {

        Optional<Profile> tempProfile = profileRepository.findById(id);

        if (!tempProfile.isPresent()) {
            throw new ResourceNotFoundException(Profile.class.getSimpleName() + " id not found - " + profile.getId());
        }

        profile.setId(id);
        profileRepository.save(profile);

        return new ResponseEntity<>("New " + Profile.class.getSimpleName() + " with id" + profile.getId() + " has been updated", HttpStatus.OK);

    }

    @DeleteMapping("/profiles/{id}")
    @Transactional
    public ResponseEntity<?> deleteProfile(@PathVariable Long id) {

        Optional<Profile> profile = profileRepository.findById(id);

        if (profile.isPresent()) {
            profileRepository.deleteById(id);
            return new ResponseEntity<>("Deleted " + Profile.class.getSimpleName() + " id - " + id, HttpStatus.OK);
        }

        throw new ResourceNotFoundException(Profile.class.getSimpleName() + " id not found - " + id);


    }


    @DeleteMapping("/profiles")
    @Transactional
    public ResponseEntity<?> deleteAllProfiles() {

        profileRepository.deleteAll();
        return new ResponseEntity<>("All Profiles have been deleted ", HttpStatus.OK);
    }


}

