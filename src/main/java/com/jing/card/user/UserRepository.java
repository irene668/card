package com.jing.card.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Integer> {

    UserModel findByUsername(String username);
    UserModel findByEmail(String email);
}
