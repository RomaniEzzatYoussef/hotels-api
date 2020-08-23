package com.romani.nozol.service.user;

import com.romani.nozol.model.User;
import java.util.List;

public interface UserService {

    List<User> getUsers();

    List<User> getUsers(Integer limit);

    void saveUser(User theUser);

    User getUser(int theId);

    int getLastID();

    User getUserByEmail(String email);

    boolean existsByEmail(String email);

    void deleteUser(int theId);

}
