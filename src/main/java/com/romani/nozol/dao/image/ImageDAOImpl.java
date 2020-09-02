package com.romani.nozol.dao.image;

import com.romani.nozol.model.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageDAOImpl implements ImageDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Image> getImages() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Image> imageQuery = currentSession.createQuery("select i from Image i", Image.class);
        List<Image> images = imageQuery.getResultList();
        return images;
    }

    @Override
    public void saveImage(Image image) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(image);
    }

    @Override
    public Image getImage(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Image image = currentSession.get(Image.class, id);
        return image;
    }

    @Override
    public void deleteImage(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Image where id=:imageId");
        query.setParameter("imageId", id);
        query.executeUpdate();
    }
}
