package io.project.classproject.web;

import io.project.classproject.domain.Ingredient;
import io.project.classproject.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/ingredients")
    private List<Ingredient> getAllIngredients(){
        return ingredientService.findAll();
    }

    @GetMapping("ingredients/{id}")
    private Ingredient getIngredient(@PathVariable Long id){
        return ingredientService.findById(id);
    }

    @DeleteMapping("/ingredients/{id}")
    private void deleteIngredient(@PathVariable Long id){
        ingredientService.delete(id);
    }

    @PostMapping("/ingredients")
    private Long saveIngredient(@RequestBody Ingredient ingredient){
        ingredientService.saveOrUpdateProfile(ingredient);
        return ingredient.getId();
    }
}
