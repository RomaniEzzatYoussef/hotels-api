package com.romani.nozol.service.user;

import com.romani.nozol.dao.user.UserDAO;
import com.romani.nozol.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // need to inject user dao
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public List<User> getUsers(Integer limit) {
        return userDAO.getUsers(limit);
    }

    @Override
    @Transactional
    public void saveUser(User theUser) {
        userDAO.saveUser(theUser);
    }

    @Override
    @Transactional
    public User getUser(int theId) {

        return userDAO.getUser(theId);
    }

    @Override
    @Transactional
    public int getLastID() {
        return userDAO.getLastID();
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    @Transactional
    public boolean existsByEmail(String email) {
        return userDAO.existsByEmail(email);
    }

    @Override
    @Transactional
    public void deleteUser(int theId) {
        userDAO.deleteUser(theId);
    }


}





