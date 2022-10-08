package com.spiringfundamentos.platzi.service;

import com.spiringfundamentos.platzi.entity.User;
import com.spiringfundamentos.platzi.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final Log log = LogFactory.getLog(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void save(List<User> users){
        users.stream()
                .peek(user ->  log.info("user insert "+user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }

    public void delete(Long id) {
         userRepository.deleteById(id);
    }

    public User update(User newUser, Long id) {
       return userRepository.findById(id)
                .map(user -> {
                    user.setBirthDate(newUser.getBirthDate());
                    user.setEmail(newUser.getEmail());
                    user.setName(newUser.getName());
                    return userRepository.save( user);
                }).get();
    }
}
