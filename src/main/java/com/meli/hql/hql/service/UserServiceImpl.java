package com.meli.hql.hql.service;

import com.meli.hql.hql.dto.UserDTO;
import com.meli.hql.hql.entity.User;
import com.meli.hql.hql.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDTO userToCreate) {
        userRepository.save(new User(userToCreate));
    }

    @Override
    public UserDTO getUser(int userId) {
        return new UserDTO(userRepository.getUserById(userId));
    }

    @Override
    public void updateUser(int userId, String newPassword) {
        userRepository.updateUserPassword(userId, newPassword);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteUserById(userId);
    }
}
