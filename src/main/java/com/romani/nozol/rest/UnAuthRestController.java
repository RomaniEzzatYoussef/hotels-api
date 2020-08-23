package com.romani.nozol.rest;

import com.romani.nozol.model.User;
import com.romani.nozol.model.UserType;
import com.romani.nozol.service.user.UserService;
import com.romani.nozol.utilities.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class UnAuthRestController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public UserRegister registerUser(@RequestBody UserRegister userRegister) throws Exception {

        if (userService.existsByEmail(userRegister.getEmail())) {
            throw new NotFoundException("EMAIL_EXISTS");
        }

        User user = new User();

        UserType userType = new UserType();
        userType.setId(2);
        userType.setUserType("USER");

        user.setUserType(userType);
        user.setName(userRegister.getName());
        user.setPhone(userRegister.getPhone());
        user.setEmail(userRegister.getEmail());
        user.setGender(userRegister.getGender());
        user.setPassword(userRegister.getPassword());
        user.setEnabled(1);

        userService.saveUser(user);

        return userRegister;
    }
}
