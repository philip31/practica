package MAIN;
import Entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main1 {
    public static void main(String[] args){


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();


        Departments d2 = new Departments();
        d2.setName("NoDepartment");

        entityTransaction.begin();


        entityManager.persist(d2);

        entityTransaction.commit();

        entityManager.close();

    }
}
