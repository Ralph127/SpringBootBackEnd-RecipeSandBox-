package io.project.classproject.repository;

import io.project.classproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserJpaRepository extends JpaRepository<User, Long> {

    User findByName(String name);
    User findByTeamName(String teamName);
}
