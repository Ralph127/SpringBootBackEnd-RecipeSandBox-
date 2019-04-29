package io.project.classproject.web;

import io.project.classproject.domain.Profile;
import io.project.classproject.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/profiles")
@CrossOrigin
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/all")
    public Iterable<Profile> getAllRecipes(){
        return profileService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRecipeById(@PathVariable Long id){
        Profile recipe = profileService.findById(id);
        return new ResponseEntity<Profile>(recipe, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id){
        profileService.delete(id);
        return new ResponseEntity<String>("Recipe Deleted", HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addRecipeToBoard(@Valid @RequestBody Profile profile, BindingResult result){

        // error mapping
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : result.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Profile newProfile = profileService.saveOrUpdateProfile(profile);

        return new ResponseEntity<Profile>(newProfile, HttpStatus.CREATED);

    }

}