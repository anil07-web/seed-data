package com.stackroute.SoulmateRESTservice.seeddata;

import com.stackroute.SoulmateRESTservice.exception.ProfileAlreadyExistsException;
import com.stackroute.SoulmateRESTservice.model.Profile;
import com.stackroute.SoulmateRESTservice.service.ProfileService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SeedAppListner implements ApplicationListener<ContextRefreshedEvent> {
    private ProfileService profileService;
    @Autowired
    public SeedAppListner(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        try {
            profileService.saveProfile(new Profile(2,"ak", "m", 25));
        } catch (ProfileAlreadyExistsException profileAlreadyExistsException) {
            profileAlreadyExistsException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
