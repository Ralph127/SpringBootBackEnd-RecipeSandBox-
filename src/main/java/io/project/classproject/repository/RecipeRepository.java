package io.project.classproject.repository;

import io.project.classproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Recipe getById(Long id);
}
