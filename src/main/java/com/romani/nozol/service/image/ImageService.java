package com.romani.nozol.service.image;

import com.romani.nozol.model.Image;

import java.util.List;

public interface ImageService {

    List<Image> getImages();

    void saveImage(Image image);

    Image getImage(int id);

    void deleteImage(int id);
}
