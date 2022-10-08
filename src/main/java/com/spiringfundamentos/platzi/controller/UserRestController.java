package com.spiringfundamentos.platzi.controller;

import com.spiringfundamentos.platzi.caseuse.CreateUser;
import com.spiringfundamentos.platzi.caseuse.DeleteUser;
import com.spiringfundamentos.platzi.caseuse.GetUser;
import com.spiringfundamentos.platzi.caseuse.UpdateUser;
import com.spiringfundamentos.platzi.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private CreateUser createUser;

    private DeleteUser deleteUser;

    private UpdateUser updateUser;


    private GetUser getUser;

    public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser) {
        this.getUser = getUser;
        this.createUser= createUser;
        this.deleteUser =deleteUser;
        this.updateUser=updateUser;
    }

    @GetMapping("/")
    List<User> get(){
       return getUser.getUsers();
    }

    @PostMapping("/")
    ResponseEntity<User> save(@RequestBody User newUser){
        return  new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable Long id){
        deleteUser.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/replace/{id}")
    ResponseEntity<User> update(@RequestBody User newUser,@PathVariable Long id){
        return  new ResponseEntity<>(updateUser.update(newUser,id), HttpStatus.OK);
    }
}
