package com.jing.card.user;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

@Service
@Validated
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    public UserModel findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserModel findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Integer addUser(UserModel user) {
        Set<ConstraintViolation<UserModel>> constraintViolations = validator.validate(user);
        if(!constraintViolations.isEmpty()){
            StringBuilder errors = new StringBuilder();
            for(ConstraintViolation<UserModel> violation : constraintViolations){
                errors.append(violation.getMessage()).append("\n");
            }
            throw new ConstraintViolationException(errors.toString(),constraintViolations);
        }
        UserModel userModel = userRepository.save(user);
        return userModel.getId();
    }
}
