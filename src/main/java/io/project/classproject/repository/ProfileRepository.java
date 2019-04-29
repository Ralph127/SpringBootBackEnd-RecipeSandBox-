package io.project.classproject.repository;

import io.project.classproject.domain.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

    Profile getById(Long id);
}
