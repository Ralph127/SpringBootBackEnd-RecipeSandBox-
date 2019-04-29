package io.project.classproject.web;

import io.project.classproject.domain.User;
import io.project.classproject.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @GetMapping(value = "/all")
    public List<User> findAll(){
        return userJpaRepository.findAll();
    }

    @GetMapping(value = "{name}")
    public User findByName(@PathVariable final String name){
        return userJpaRepository.findByName(name);
    }

    @PostMapping(value ="/load")
    public User load(@RequestBody final User user){
        userJpaRepository.save(user);
        return userJpaRepository.findByName(user.getName());
    }
}
