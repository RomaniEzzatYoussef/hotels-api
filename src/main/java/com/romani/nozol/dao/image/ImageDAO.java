package com.romani.nozol.dao.image;

import com.romani.nozol.model.Image;

import java.util.List;

public interface ImageDAO {

    List<Image> getImages();

    void saveImage(Image image);

    Image getImage(int id);

    void deleteImage(int id);
}
