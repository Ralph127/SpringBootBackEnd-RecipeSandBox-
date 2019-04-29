package io.project.classproject.service;

import io.project.classproject.domain.Profile;
import io.project.classproject.domain.Recipe;
import io.project.classproject.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile saveOrUpdateProfile(Profile profile){
        return profileRepository.save(profile);
    }

    public Iterable<Profile> findAll(){
        return profileRepository.findAll();
    }

    public Profile findById(Long id){
        return profileRepository.getById(id);
    }

    public void delete(Long id){
        Profile profile = findById(id);
        profileRepository.delete(profile);
    }
}
