package com.devsuperior.userdept.controllers;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    // Endpoint para obter todos os usuários
    @GetMapping
    public List<User> findAll(){
         List<User> result = repository.findAll();
         return result;
    }

    // Endpoint para obter um usuário por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> optionalUser = repository.findById(id);

        return optionalUser.map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para inserir um novo usuário
    @PostMapping
    public User insert(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }

}
