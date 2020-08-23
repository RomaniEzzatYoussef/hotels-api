package com.romani.nozol.rest;

import com.romani.nozol.model.*;
import com.romani.nozol.service.category.CategoryService;
import com.romani.nozol.service.categoryService.CategoryServiceService;
import com.romani.nozol.service.categoryType.CategoryTypeService;
import com.romani.nozol.service.service.ServiceService;
import com.romani.nozol.service.user.UserService;
import com.romani.nozol.service.userType.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public class AuthRestController {

    @Autowired
    UserService userService;

    @Autowired
    UserTypeService userTypeService;

    @Autowired
    CategoryTypeService categoryTypeService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryServiceService categoryServiceService;

    @Autowired
    ServiceService serviceService;

    @RequestMapping("/usersTypes")
    public List<UserType> getUserTypes() {
        return userTypeService.getUserTypes();
    }

    @RequestMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping("/categoryTypes")
    public List<CategoryType> getCategoryTypes() {
        return categoryTypeService.getCategoryTypes();
    }

    @RequestMapping("/categoryType/{id}/categories")
    public List<Category> getCategoriesByCategoryType(@PathVariable int id , @RequestParam(required = false) Integer limit , @RequestParam(required = false) Integer pageNumber) {
        return categoryService.getCategoriesByCategoryType(id);
    }

    @RequestMapping("/category/{id}")
    public Category getCategory(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

    @RequestMapping("/category/{id}/categoryServices")
    public List<com.romani.nozol.model.CategoryService> getCategoryServicesByCategoryId(@PathVariable int id , @RequestParam(required = false) Integer limit , @RequestParam(required = false) Integer pageNumber) {
        return categoryServiceService.getCategoryServicesByCategoryId(id);
    }

    @RequestMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @RequestMapping("/categoryService/{id}")
    public com.romani.nozol.model.CategoryService getCategoryServiceById(@PathVariable int id) {
        return categoryServiceService.getCategoryService(id);
    }

    @RequestMapping("/categoryServices")
    public List<com.romani.nozol.model.CategoryService> getCategoryServices() {
        return categoryServiceService.getCategoryServices();
    }

    @RequestMapping("/services")
    public List<Service> getServices() {
        return serviceService.getServices();
    }

    @RequestMapping("/categoryService/{id}/services")
    public List<Service> getServicesByCategoryServiceId(@PathVariable int id) {
        return serviceService.getServicesByCategoryServiceId(id);
    }
}


	

















