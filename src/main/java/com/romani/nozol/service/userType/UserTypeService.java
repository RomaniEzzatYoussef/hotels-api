package com.romani.nozol.service.userType;

import com.romani.nozol.model.UserType;

import java.util.List;


public interface UserTypeService {

    List<UserType> getUserTypes();

    void saveUserType(UserType theUserType);

    UserType getUserType(int theId);

    void deleteUserType(int theId);

}
