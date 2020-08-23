package com.romani.nozol.dao.user;

import com.romani.nozol.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private int paginatedCount = 0;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> theQuery = currentSession.createQuery("select u From User u", User.class);

        List<User> users = theQuery.getResultList();
        return users;
    }

    @Override
    public List<User> getUsers(Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> userQuery = currentSession.createQuery("select u From User u", User.class);
        userQuery.setFirstResult(paginatedCount);
        userQuery.setMaxResults(limit);
        List<User> users = userQuery.getResultList();

        paginatedCount += limit;

        int pageSize;

        if (limit > users.size()) {
            pageSize = 1;

        } else {
            pageSize = (users.size() / limit) + 1;
        }

        if (pageSize == 1) {
            paginatedCount = 0;
        }
        return users;
    }

    @Override
    public void saveUser(User theUser) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theUser);
    }

    @Override
    public User getUser(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        User user = currentSession.get(User.class, id);

        if (user == null) {
            throw new NotFoundException("userId not found with id: " + id);
        }

        return user;
    }

    @Override
    public int getLastID() {

        Session currentSession = sessionFactory.getCurrentSession();
        int lastId = (int) currentSession.createQuery("SELECT max(u.id) from User u").getResultList().get(0);

        return lastId;
    }

    @Override
    public User getUserByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> query = currentSession.createQuery("select u from User u where u.email =:email" , User.class);
        query.setParameter("email", email);
        User user;

        if (query.getResultList().size() == 0) {
            throw new NotFoundException("EMAIL_NOT_FOUND");
//            throw new NotFoundException("user not found with email: " + email);
        } else {
            user = query.getResultList().get(0);
        }

        return user;
    }

    @Override
    public boolean existsByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("select u from User u where u.email=:email" , User.class);
        query.setParameter("email", email);

        User user;
        if (!query.getResultList().isEmpty()) {
            user =  query.getSingleResult();
        } else {
            user = null;
        }

        if (user == null) {
            return false;
        }


        return true;
    }

    @Override
    public void deleteUser(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from User where id=:userId");
        theQuery.setParameter("userId", theId);

        theQuery.executeUpdate();
    }

}











