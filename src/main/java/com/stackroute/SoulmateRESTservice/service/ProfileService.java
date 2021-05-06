package com.stackroute.SoulmateRESTservice.service;

import com.stackroute.SoulmateRESTservice.exception.ProfileAlreadyExistsException;
import com.stackroute.SoulmateRESTservice.exception.ProfileNotFoundException;
import com.stackroute.SoulmateRESTservice.model.Profile;

import java.util.List;

public interface ProfileService {
    Profile saveProfile(Profile profile) throws ProfileAlreadyExistsException, Exception;

    List<Profile> getALLProfiles() throws Exception;

    void delete(int id) throws ProfileNotFoundException, Exception;

    Profile getProfileById(int id) throws ProfileNotFoundException, Exception;

    Profile updateProfile(Profile profile) throws ProfileNotFoundException, Exception;

    List<Profile> findProfileByName(String name) throws ProfileNotFoundException, Exception;

}
