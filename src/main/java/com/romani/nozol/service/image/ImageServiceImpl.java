package com.romani.nozol.service.image;

import com.romani.nozol.dao.image.ImageDAO;
import com.romani.nozol.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageDAO imageDAO;

    @Override
    @Transactional
    public List<Image> getImages() {
        return imageDAO.getImages();
    }

    @Override
    @Transactional
    public void saveImage(Image image) {
        imageDAO.saveImage(image);
    }

    @Override
    @Transactional
    public Image getImage(int id) {
        return imageDAO.getImage(id);
    }

    @Override
    @Transactional
    public void deleteImage(int id) {
        imageDAO.deleteImage(id);
    }
}
