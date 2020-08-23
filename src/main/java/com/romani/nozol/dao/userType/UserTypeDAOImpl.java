package com.romani.nozol.dao.userType;

import com.romani.nozol.model.UserType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserTypeDAOImpl implements UserTypeDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UserType> getUserTypes() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<UserType> theQuery =
                currentSession.createQuery("From UserType",
                        UserType.class);

        // execute query and get result list
        List<UserType> UserTypes = theQuery.getResultList();

        // return the results
        return UserTypes;
    }

    @Override
    public void saveUserType(UserType theUserType) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the UserType ... finally LOL
        currentSession.saveOrUpdate(theUserType);

    }

    @Override
    public UserType getUserType(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        UserType theUserType = currentSession.get(UserType.class, theId);

        return theUserType;
    }

    @Override
    public void deleteUserType(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from UserType where id=:userTypeId");
        theQuery.setParameter("userTypeId", theId);

        theQuery.executeUpdate();
    }

}











