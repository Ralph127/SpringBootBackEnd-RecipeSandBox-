package io.project.classproject.repository;

import io.project.classproject.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    Ingredient getById(Long id);
    Ingredient getByName(String name);
    Ingredient getBySummary(String summary);
}
