package com.stackroute.SoulmateRESTservice.seeddata;

import com.stackroute.SoulmateRESTservice.model.Profile;
import com.stackroute.SoulmateRESTservice.service.ProfileService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedCmdLine implements CommandLineRunner {
    @Autowired
    private ProfileService profileService;

    public SeedCmdLine(ProfileService profileService) {
        this.profileService = profileService;
    }

    @SneakyThrows
    @Override
    public void run(String... args) throws Exception {
        profileService.saveProfile(new Profile(30,"divya", "m", 21));
        profileService.saveProfile(new Profile(35,"nikita", "f", 27));
    }
}
