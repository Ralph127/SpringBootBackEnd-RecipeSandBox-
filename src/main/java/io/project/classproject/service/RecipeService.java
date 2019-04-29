package io.project.classproject.service;

import io.project.classproject.domain.Recipe;
import io.project.classproject.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe saveOrUpdateRecipe(Recipe recipe){
        if(recipe.getCuisine() == null || recipe.getCuisine() == ""){
            recipe.setCuisine("Unknown");
        }
        return recipeRepository.save(recipe);
    }

    public Iterable<Recipe> findAll(){
        return recipeRepository.findAll();
    }

    public Recipe findById(Long id){
        return recipeRepository.getById(id);
    }

    public void delete(Long id){
        Recipe recipe = findById(id);
        recipeRepository.delete(recipe);
    }
}
