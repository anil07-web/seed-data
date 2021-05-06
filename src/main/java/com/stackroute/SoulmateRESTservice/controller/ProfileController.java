package com.stackroute.SoulmateRESTservice.controller;

import com.stackroute.SoulmateRESTservice.exception.ProfileAlreadyExistsException;
import com.stackroute.SoulmateRESTservice.exception.ProfileNotFoundException;
import com.stackroute.SoulmateRESTservice.model.Profile;
import com.stackroute.SoulmateRESTservice.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1")
public class ProfileController {
    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    // This method is used for Saving the given profile//
    @PostMapping("/profile")
    public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile) throws ProfileAlreadyExistsException, Exception {
        Profile savedprofile = profileService.saveProfile(profile);
        log.info("This is info message");
        return new ResponseEntity<>(savedprofile, HttpStatus.CREATED);
    }

    // This method is used for Retriving the saved profiles//
    @GetMapping("/profiles")
    public ResponseEntity<?> getAllProfiles() throws Exception {
        List<Profile> profileList = profileService.getALLProfiles();
        return new ResponseEntity<>(profileList, HttpStatus.FOUND);
    }

    //Deleting the profile Based on Id//
    @DeleteMapping("/profile/{id}")
    private void deleteProfile(@PathVariable("id") int id) throws ProfileNotFoundException, Exception {
        profileService.delete(id);
    }

    //Searching the profile in database based on Id//
    @GetMapping("/profile/{id}")
    private Profile getProfile(@PathVariable("id") int id) throws ProfileNotFoundException, Exception {
        return profileService.getProfileById(id);
    }

    //Updating the profile values Based on Id//
    @PutMapping("/profile/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable int id, @RequestBody Profile profile) throws ProfileNotFoundException, Exception {
        profile.setId(id);
        return ResponseEntity.ok().body(this.profileService.updateProfile(profile));
    }

    //Search the profile  Based on name//
    @GetMapping("/profiles/name")
    public ResponseEntity<List<Profile>> profileByName(@RequestParam(value = "name") String name) throws ProfileNotFoundException, Exception {
        return new ResponseEntity<List<Profile>>((List<Profile>) profileService.findProfileByName(name), HttpStatus.OK);

    }

    @GetMapping("/msg")
    public String getMessage() {
        log.info("This is info msg");
        log.debug("This is debug msg");
        log.trace("This is trace msg");
        log.warn("This is warn msg");
        log.error("This is error msg");
        return "msg";
    }
}
