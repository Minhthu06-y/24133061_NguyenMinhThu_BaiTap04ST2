package vn.iotstar.connect;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConnect {

    private static EntityManagerFactory factory;

    public static EntityManager getEntityManager() {

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("UserManagement");
        }

        return factory.createEntityManager();
    }
}