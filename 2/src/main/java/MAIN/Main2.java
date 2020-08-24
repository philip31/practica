package MAIN;

import Entity.Departments;
import Entity.Employees;
import Entity.JobCategories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();


        entityTransaction.begin();

        Departments d1 = new Departments();
        d1.setName("Finance");

        Departments d2 = new Departments();
        d2.setName("Marketing");

        JobCategories j1 = new JobCategories();
        j1.setName("Summer Intern");

        Employees e1 = new Employees();
        e1.setFirstName("Marcel");
        e1.setLastName("Pavel");
        e1.setDepartment(d1);
        e1.setJobCategories(j1);
        e1.setStartDate(LocalDate.now());
        e1.setAddress("Strada soarelui nr 123");
        e1.setCP("040404");
        e1.setTelephone("0731444999");
        e1.setBirthday(LocalDate.of(1998,11,23));
        e1.setSalary(2000);
        e1.setStudies("ASE");
        e1.setSocialSecurityNumber("3335556666");
        e1.setHasDrivingLicence(1);

        Employees e2 = new Employees();
        e2.setFirstName("Andrei");
        e2.setLastName("Popovici");
        e2.setDepartment(d1);
        e2.setJobCategories(j1);
        e2.setStartDate(LocalDate.now());
        e2.setAddress("Strada vulpii nr 12");
        e2.setCP("040404");
        e2.setTelephone("0731444999");
        e2.setBirthday(LocalDate.of(1998,11,23));
        e2.setSalary(2500);
        e2.setStudies("POLI");
        e2.setSocialSecurityNumber("3339906646");
        e2.setHasDrivingLicence(1);

        List<Employees> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);

        d1.setEmployees_list(employees);
        j1.setEmployees_list(employees);

        entityManager.persist(d1);
        entityManager.persist(j1);

        for(Employees e : employees)
            entityManager.persist(e);

        entityTransaction.commit();
        entityManager.close();
    }
}
