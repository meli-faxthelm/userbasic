package com.meli.hql.hql.service;

import com.meli.hql.hql.dto.UserDTO;

public interface UserService {

    void createUser(UserDTO userToCreate);
    UserDTO getUser(int userId);
    void updateUser(int userId, String newPassword);
    void deleteUser(int userId);

}
