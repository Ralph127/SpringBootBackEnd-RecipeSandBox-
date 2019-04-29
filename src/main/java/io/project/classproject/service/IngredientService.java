package io.project.classproject.service;

import io.project.classproject.domain.Ingredient;
import io.project.classproject.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient saveOrUpdateProfile(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> findAll(){
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredientRepository.findAll().forEach(ingredient -> ingredients.add(ingredient));
        return ingredients;
    }

    public Ingredient findById(Long id){
        return ingredientRepository.getById(id);
    }

    public void delete(Long id){
        Ingredient ingredient = findById(id);
        ingredientRepository.delete(ingredient);
    }

    public Ingredient findByName(String name) { return ingredientRepository.getByName(name);}

    public Ingredient findBySummary(String summary) { return ingredientRepository.getBySummary(summary);}
}
