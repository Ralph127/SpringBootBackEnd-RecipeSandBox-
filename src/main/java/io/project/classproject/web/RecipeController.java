package io.project.classproject.web;

import io.project.classproject.domain.Recipe;
import io.project.classproject.service.RecipeService;
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
@RequestMapping("/api/board")
@CrossOrigin
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/all")
    public Iterable<Recipe> getAllRecipes(){
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRecipeById(@PathVariable Long id){
        Recipe recipe = recipeService.findById(id);
        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id){
        recipeService.delete(id);
        return new ResponseEntity<String>("Recipe Deleted", HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addRecipeToBoard(@Valid @RequestBody Recipe recipe, BindingResult result){

        // error mapping
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : result.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Recipe newRecipe = recipeService.saveOrUpdateRecipe(recipe);

        return new ResponseEntity<Recipe>(newRecipe, HttpStatus.CREATED);

    }

}
