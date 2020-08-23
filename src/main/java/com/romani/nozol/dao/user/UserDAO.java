package com.romani.nozol.dao.user;


import com.romani.nozol.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    List<User> getUsers(Integer limit);

    void saveUser(User User);

    User getUser(int id);

    int getLastID();

    User getUserByEmail(String email);

    boolean existsByEmail(String email);

    void deleteUser(int id);

}
