package vn.iotstar.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import vn.iotstar.connect.JPAConnect;
import vn.iotstar.dao.UserDao;
import vn.iotstar.model.User;

public class UserDaoImpl implements UserDao {

    @Override
    public User findById(int id) {

        EntityManager entityManager = JPAConnect.getEntityManager();

        try {
            return entityManager.find(User.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(User user) {

        EntityManager entityManager = JPAConnect.getEntityManager();

        EntityTransaction transaction =
                entityManager.getTransaction();

        try {

            transaction.begin();

            entityManager.merge(user);

            transaction.commit();

        } catch (Exception e) {

            if (transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();

        } finally {

            entityManager.close();
        }
    }
}