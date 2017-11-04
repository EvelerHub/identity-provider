package com.evedev.identityprovider.repositories.handlers;

import com.evedev.identityprovider.models.group_scheme.User;
import com.evedev.identityprovider.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 20.10.17
 */
@Component
@RepositoryEventHandler(value = User.class)
public class UserEventHandler {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @HandleBeforeCreate
    public void handleUserCreate(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    @HandleBeforeSave
    public void handleUserUpdate(User user) {
        if (user.getPassword() == null || user.getPassword().equals("")) {
            //keeps the last password
            User storedUser = userRepository.findOne(user.getId());
            user.setPassword(storedUser.getPassword());
        } else {
            //password change request
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
    }
}
