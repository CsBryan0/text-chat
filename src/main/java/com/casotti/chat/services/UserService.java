package com.casotti.chat.services;

import com.casotti.chat.entities.User;

public interface UserService {
    User registerUser(User user);
    User getCurrentUser();
}
