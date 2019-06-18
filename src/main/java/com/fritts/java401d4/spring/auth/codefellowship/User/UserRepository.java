package com.fritts.java401d4.spring.auth.codefellowship.User;


import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
