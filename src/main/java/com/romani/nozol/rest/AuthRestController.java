package com.romani.nozol.rest;

import com.romani.nozol.model.*;
import com.romani.nozol.service.category.CategoryService;
import com.romani.nozol.service.categoryService.CategoryServiceService;
import com.romani.nozol.service.categoryType.CategoryTypeService;
import com.romani.nozol.service.image.ImageService;
import com.romani.nozol.service.service.ServiceService;
import com.romani.nozol.service.user.UserService;
import com.romani.nozol.service.userType.UserTypeService;
import com.romani.nozol.utilities.exceptions.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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

    @Autowired
    ImageService imageService;

    @GetMapping("/user/current")
    public User getCurrentUser(Principal principal) {
        return userService.getUserByEmail(principal.getName());
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return  userService.getUser(id);
    }

    @GetMapping("/usersTypes")
    public List<UserType> getUserTypes() {
        return userTypeService.getUserTypes();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/categoryTypes")
    public List<CategoryType> getCategoryTypes() {
        return categoryTypeService.getCategoryTypes();
    }

    @GetMapping("/categoryType/{id}/categories")
    public List<Category> getCategoriesByCategoryType(@PathVariable int id , @RequestParam(required = false) Integer limit , @RequestParam(required = false) Integer pageNumber) {
        return categoryService.getCategoriesByCategoryType(id);
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("/category/{id}/categoryServices")
    public List<com.romani.nozol.model.CategoryService> getCategoryServicesByCategoryId(@PathVariable int id , @RequestParam(required = false) Integer limit , @RequestParam(required = false) Integer pageNumber) {
        return categoryServiceService.getCategoryServicesByCategoryId(id);
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/categoryService/{id}")
    public com.romani.nozol.model.CategoryService getCategoryServiceById(@PathVariable int id) {
        return categoryServiceService.getCategoryService(id);
    }

    @GetMapping("/categoryServices")
    public List<com.romani.nozol.model.CategoryService> getCategoryServices() {
        return categoryServiceService.getCategoryServices();
    }

    @GetMapping("/services")
    public List<Service> getServices() {
        return serviceService.getServices();
    }

    @GetMapping("/categoryService/{id}/services")
    public List<Service> getServicesByCategoryServiceId(@PathVariable int id) {
        return serviceService.getServicesByCategoryServiceId(id);
    }

    @PostMapping(value = "/image/upload", consumes  = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ErrorResponse uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        Image image = new Image(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
        imageService.saveImage(image);
        return new ErrorResponse( 200, HttpStatus.OK + "" , new Date().getTime());
    }


    @GetMapping(path = { "/image/{imageID}" })
    public Image getImage(@PathVariable("imageID") int imageID) throws IOException {
        final Optional<Image> retrievedImage = Optional.ofNullable(imageService.getImage(imageID));
        Image image = new Image(retrievedImage.get().getName(), retrievedImage.get().getType(), decompressBytes(retrievedImage.get().getImageByte()));
        return image;
    }

    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }

}


	

















