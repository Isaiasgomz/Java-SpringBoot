package com.spiringfundamentos.platzi.repository;

import com.spiringfundamentos.platzi.entity.User;
import org.hibernate.annotations.Parameter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM  User u WHERE u.email = ?1")
    Optional<User> findByUserByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name LIKE ?1%  ")
    List<User> findByNameAndSort(String name, Sort sort);

    List<User> findByName(String name);

    Optional<User> findByNameAndEmail(String name, String email);


    List<User> findByNameLike(String name);

    List<User> findByNameOrderById(String name);

    List<User> findByNameContaining(String name);

    Optional<User> findUsersByNameAndAndEmail(String name, String email);

    Optional<User> findUsersByNameOrAndEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameContainingOrderByIdDesc(String name);

//    @Query("selec u from Useer u where u.name= :name or u.email= :email")
//    Optional<User> findByNameOrEmail(
//            @Param("name") String name,
//            @Param("emai") String email
//    );

}
