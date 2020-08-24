package MAIN;

import Entity.Departments;
import Entity.Employees;
import Entity.JobCategories;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;



public class Main3 {
    private final static Logger LOGGER = Logger.getLogger(Main3.class.getName());





    public static void Meniu(EntityManager entityManager) {
        boolean ok = true;
        while(ok){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ce actiune doriti sa executati?");
            System.out.println("1. Select");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Order Tables");

            String raspuns = sc.nextLine();

            switch(raspuns){
                case "1":{
                    while(ok){
                        System.out.println("Din ce tabela doriti sa Selectati?");
                        System.out.println("1. Employees");
                        System.out.println("2. Departments");
                        System.out.println("3. Job Categories");
                        raspuns = sc.nextLine();

                        if(!raspuns.equals("1")  && !raspuns.equals("2") && !raspuns.equals("3")){
                            break;
                        }
                        Select(entityManager,raspuns);
                    }

                    break;
                }
                case "2":{
                    while(ok){
                        System.out.println("Din ce tabela doriti sa Updatati?");
                        System.out.println("1. Employees");
                        System.out.println("2. Departments");
                        System.out.println("3. Job Categories");
                        raspuns =sc.nextLine();

                        if(!raspuns.equals("1")  && !raspuns.equals("2") && !raspuns.equals("3")){
                            break;
                        }

                        Update(entityManager,raspuns);
                    }

                    break;
                }
                case "3":{
                    while(ok){
                        System.out.println("Din ce tabela doriti sa dati Delete?");
                        System.out.println("1. Employees");
                        System.out.println("2. Departments");
                        System.out.println("3. Job Categories");
                        raspuns =sc.nextLine();

                        if(!raspuns.equals("1")  && !raspuns.equals("2") && !raspuns.equals("3")){
                            break;
                        }

                        Delete(entityManager,raspuns);
                    }

                    break;
                }
                case "4":{
                    while(ok){
                        System.out.println("Din ce tabela doriti sa Selectati?");
                        System.out.println("1. Departments");
                        System.out.println("2. Job Categories");
                        raspuns =sc.nextLine();

                        if(!raspuns.equals("1")  && !raspuns.equals("2")){
                            break;
                        }

                        OrderBy(entityManager,raspuns);
                    }
                    break;
                }
                default:{
                    ok = false;
                    break;
                }
        }

        }





    }
    public static void Select(EntityManager entityManager, String tabela){

        if(tabela.equals("1")){
            while(true){
                System.out.println("Pe cine vrei sa selectezi?");
                Query query = entityManager.
                        createQuery("Select e.lastName from Employees e");
                List<String> list = query.getResultList();
                query = entityManager.
                        createQuery("Select e.firstName from Employees e");
                List<String> list1 = query.getResultList();
                for(int i =0; i< list.size(); i++){
                    System.out.println(list.get(i)+" "+list1.get(i));
                }
                Scanner sc = new Scanner(System.in);
                String[] raspuns;

                raspuns = sc.nextLine().split(" ");

                if(!list.contains(raspuns[0]) || !list1.contains(raspuns[1])){
                    break;
                }

                query = entityManager.
                        createQuery("Select e from Employees e where e.lastName = :r1 and e.firstName = :r2 ");
                query.setParameter("r1", raspuns[0]);
                query.setParameter("r2", raspuns[1]);
                List<Employees>  emp = (List<Employees>) query.getResultList();

                System.out.println(emp);

            }

        }else {

            if (tabela.equals("2")) {
                while (true) {
                    System.out.println("Ce Departament vrei sa selectezi?");

                    Query query = entityManager.
                            createQuery("Select d.name from Departments d");
                    List<String> list = query.getResultList();

                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                    }
                    Scanner sc = new Scanner(System.in);
                    String raspuns;
                    raspuns = sc.nextLine();

                    if (!list.contains(raspuns)) {
                        break;
                    }

                    query = entityManager.
                            createQuery("Select d from Departments d where d.name = :r");
                    query.setParameter("r", raspuns);
                    List<Departments> dep = ((List<Departments>) query.getResultList());

                    System.out.println(dep);

                }


            }else{
                while(true){
                    System.out.println("Ce Job Category vrei sa selectezi?");

                    Query query = entityManager.
                            createQuery("Select j.name from JobCategories j");
                    List<String> list = query.getResultList();

                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                    }

                    Scanner sc = new Scanner(System.in);
                    String raspuns;
                    raspuns = sc.nextLine();

                    if (!list.contains(raspuns)) {
                        break;
                    }

                    query = entityManager.
                            createQuery("Select j from JobCategories j where j.name = :r");
                    query.setParameter("r",raspuns);
                    List<JobCategories> job = (List<JobCategories>)query.getResultList();


                    System.out.println(job);
                }
            }
        }


    }
    public static void Update(EntityManager entityManager, String tabela){
        if(tabela.equals("1")){

            System.out.println("Pe cine vrei sa selectezi?");
            Query query = entityManager.
                    createQuery("Select e.lastName from Employees e");
            List<String> list = query.getResultList();
            query = entityManager.
                    createQuery("Select e.firstName from Employees e");
            List<String> list1 = query.getResultList();
            for(int i =0; i< list.size(); i++){
                System.out.println(list.get(i)+" "+list1.get(i));
            }
            Scanner sc = new Scanner(System.in);
            String[] raspuns;
            raspuns = sc.nextLine().split(" ");

            query = entityManager.
                    createQuery("Select e from Employees e where e.lastName = :r1 and e.firstName = :r2 ");
            query.setParameter("r1", raspuns[0]);
            query.setParameter("r2", raspuns[1]);
            List<Employees>  emp = (List<Employees>) query.getResultList();

            System.out.println("Ce informatie vrei sa updatezi?");
            System.out.println("" +
                    "1. firstName \n" +
                    "2. lastName \n" +
                    "3. department \n" +
                    "4. jobCategories \n" +
                    "5. isManager \n" +
                    "6. startDate \n" +
                    "7. endDate \n" +
                    "8. active \n " +
                    "9. address \n " +
                    "10. CP \n " +
                    "11. telephone \n" +
                    "12. email \n " +
                    "13. birthday \n " +
                    "14. noChildren \n" +
                    "15. salary\n" +
                    "16. studies\n" +
                    "17. socialSecurityNumber \n" +
                    "18. hasDrivingLicence;");


            switch(sc.nextLine()){
                case "1":{
                    System.out.println("introduceti o valoare noua");
                    emp.get(0).setFirstName(sc.nextLine());
                    break;
                }
                case "2":{
                    System.out.println("introduceti o valoare noua");
                    emp.get(0).setLastName(sc.nextLine());
                    break;
                }
                case "3":{
                    System.out.println("introduceti o valoare noua");
                    query = entityManager.
                            createQuery("Select d from Departments d where d.name = :r1");
                    query.setParameter("r1", sc.nextLine());

                    List<Departments> dep =(List<Departments>) query.getResultList();


                    emp.get(0).setDepartment(dep.get(0));
                    dep.get(0).AddToList(emp.get(0));
                    break;
                }
                case "4":{
                    System.out.println("introduceti o valoare noua");
                    query = entityManager.
                            createQuery("Select j from JobCategories j where j.name = :r1");
                    query.setParameter("r1", sc.nextLine());

                    List<JobCategories> job =(List<JobCategories>) query.getResultList();


                    emp.get(0).setJobCategories(job.get(0));
                    job.get(0).AddToList(emp.get(0));
                    break;
                }
                case "5":{
                    System.out.println("introduceti o valoare noua");
                    emp.get(0).setIsManager(sc.nextInt());
                    break;
                }
                case "6":{

                    System.out.println("Introduceti anul");
                    int an=sc.nextInt();
                    System.out.println("Introduceti luna");
                    int luna=sc.nextInt();
                    System.out.println("Introduceti ziua");
                    int zi=sc.nextInt();
                    emp.get(0).setStartDate(LocalDate.of(an,luna,zi));
                    break;
                }
                case "7":{
                    System.out.println("Introduceti anul");
                    int an=sc.nextInt();
                    System.out.println("Introduceti luna");
                    int luna=sc.nextInt();
                    System.out.println("Introduceti ziua");
                    int zi=sc.nextInt();
                    emp.get(0).setEndDate(LocalDate.of(an,luna,zi));
                    break;
                }
                case "8":{
                    System.out.println("introduceti o valoare noua");
                    emp.get(0).setActive(sc.nextInt());
                    break;
                }
                case "9":{
                    System.out.println("introduceti o valoare noua");
                    emp.get(0).setAddress(sc.nextLine());
                    break;
                }
                case "10":{
                    System.out.println("introduceti o valoare noua");
                    emp.get(0).setCP(sc.nextLine());
                    break;
                }
                case "11":{
                    System.out.println("introduceti o valoare noua");
                    emp.get(0).setTelephone(sc.nextLine());
                    break;
                }
                case "12":{
                    System.out.println("introduceti o valoare noua");
                    emp.get(0).setEmail(sc.nextLine());
                    break;
                }
                case "13":{

                    System.out.println("Introduceti anul");
                    int an=sc.nextInt();
                    System.out.println("Introduceti luna");
                    int luna=sc.nextInt();
                    System.out.println("Introduceti ziua");
                    int zi=sc.nextInt();
                    emp.get(0).setBirthday(LocalDate.of(an,luna,zi));
                    break;
                }
                case "14":{
                    System.out.println("introduceti o valoare noua");
                    emp.get(0).setNoChildren(sc.nextInt());
                    break;
                }
                case "15":{
                    System.out.println("introduceti o valoare noua");
                    emp.get(0).setSalary(sc.nextInt());
                    break;
                }
                case "16":{
                    System.out.println("introduceti o valoare noua");
                    emp.get(0).setStudies(sc.nextLine());
                    break;
                }
                case "17":{
                    System.out.println("introduceti o valoare noua");
                    emp.get(0).setSocialSecurityNumber(sc.nextLine());
                    break;
                }
                case "18":{
                    System.out.println("introduceti o valoare noua");
                    emp.get(0).setHasDrivingLicence(sc.nextInt());
                    break;
                }
                default:{
                    break;
                }
            }
            System.out.println(emp);

        }else {
            if (tabela.equals("2")) {

                System.out.println("Ce Departament vrei sa selectezi?");

                Query query = entityManager.
                        createQuery("Select d.name from Departments d");
                List<String> list = query.getResultList();

                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
                Scanner sc = new Scanner(System.in);
                String raspuns;
                raspuns = sc.nextLine();
                query = entityManager.
                        createQuery("Select d from Departments d where d.name = :r");
                query.setParameter("r",raspuns);
                List<Departments> dep = ((List<Departments>) query.getResultList());

                System.out.println("Ce informatie vrei sa updatezi?");

                System.out.println("1. name");

                switch(sc.nextLine()){
                    case "1":{
                        System.out.println("Introduceti o valoarea noua");
                        dep.get(0).setName(sc.nextLine());
                        break;
                    }
                    default:{

                        break;
                    }
                }

                System.out.println(dep);

            }else{
                System.out.println("Ce Job Category vrei sa selectezi?");

                Query query = entityManager.
                        createQuery("Select j.name from JobCategories j");
                List<String> list = query.getResultList();

                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }

                Scanner sc = new Scanner(System.in);
                String raspuns;
                raspuns = sc.nextLine();

                query = entityManager.
                        createQuery("Select j from JobCategories j where j.name = :r");
                query.setParameter("r",raspuns);
                List<JobCategories> job = (List<JobCategories>)query.getResultList();

                System.out.println("Ce informatie vrei sa updatezi?");

                System.out.println("1. name");

                switch(sc.nextLine()){
                    case "1":{
                        System.out.println("Introduceti o valoarea noua");
                        job.get(0).setName(sc.nextLine());
                        break;
                    }
                    default:{

                        break;
                    }
                }

                System.out.println(job);
            }
        }
    }
    public static void Delete(EntityManager entityManager, String tabela) {

        if (tabela.equals("1")) {
            while(true){
                System.out.println("Pe cine vrei sa elimini?");
                Query query = entityManager.
                        createQuery("Select e.lastName from Employees e");
                List<String> list = query.getResultList();
                query = entityManager.
                        createQuery("Select e.firstName from Employees e");
                List<String> list1 = query.getResultList();
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i) + " " + list1.get(i));
                }
                Scanner sc = new Scanner(System.in);
                String[] raspuns;
                raspuns = sc.nextLine().split(" ");

                if (!list.contains(raspuns)) {
                    break;
                }

                query = entityManager.
                        createQuery("Delete from Employees e where e.lastName = :r1 and e.firstName = :r2 ");
                query.setParameter("r1", raspuns[0]);
                query.setParameter("r2", raspuns[1]);
                query.executeUpdate();


                System.out.println(raspuns[0] +" "+raspuns[1] +" a fost eliminat.");

            }

        } else {

            if (tabela.equals("2")) {
                while(true){
                    System.out.println("Ce Departament vrei sa elimini?");

                    Query query = entityManager.
                            createQuery("Select d.name from Departments d");
                    List<String> list = query.getResultList();

                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                    }
                    Scanner sc = new Scanner(System.in);
                    String raspuns;
                    raspuns = sc.nextLine();

                    if (!list.contains(raspuns)) {
                        break;
                    }

                    query = entityManager.
                            createQuery("Select d from Departments d where d.name = :r");
                    query.setParameter("r", raspuns);

                    List<Departments> dep = (List<Departments>)query.getResultList();
                    List<Employees> employeesList = dep.get(0).getEmployees_list();

                    query = entityManager.
                            createQuery("Select d from Departments d where d.name = :r");
                    query.setParameter("r", "NoDepartment");

                    Departments d =(Departments) query.getResultList().get(0);

                    for(Employees e : employeesList){
                        e.setDepartment(d);
                    }

                    query = entityManager.
                            createQuery("Delete from Departments d where d.name = :r");
                    query.setParameter("r", raspuns);
                    query.executeUpdate();


                    System.out.println(raspuns +" a fost eliminat");

                }

            } else {
                while(true){
                    System.out.println("Ce Job Category vrei sa selectezi?");

                    Query query = entityManager.
                            createQuery("Select j.name from JobCategories j");
                    List<String> list = query.getResultList();

                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                    }

                    Scanner sc = new Scanner(System.in);
                    String raspuns;
                    raspuns = sc.nextLine();

                    if (!list.contains(raspuns)) {
                        break;
                    }

                    query = entityManager.
                            createQuery("Delete from JobCategories j where j.name = :r");
                    query.setParameter("r", raspuns);
                    query.executeUpdate();


                    System.out.println(raspuns +" a fost eliminat.");
                }

            }
        }
    }
    public static void OrderBy(EntityManager entityManager, String tabela) {
        if(tabela.equals("1")){
            boolean ok = true;
            while (ok) {
                System.out.println("Ce Departament vrei sa selectezi?");

                Query query = entityManager.
                        createQuery("Select d.name from Departments d");
                List<String> list = query.getResultList();

                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
                Scanner sc = new Scanner(System.in);
                String raspuns;
                raspuns = sc.nextLine();

                if (!list.contains(raspuns)) {
                    break;
                }

                query = entityManager.
                        createQuery("Select d from Departments d where d.name = :r");
                query.setParameter("r", raspuns);
                List<Departments> dep = ((List<Departments>) query.getResultList());



                List<Employees> employeesList = dep.get(0).getEmployees_list();

                System.out.println("Dupa ce criteriu vrei sa ordonezi lista?");
                System.out.println("1. Nume");
                System.out.println("2. Prenume");
                System.out.println("3. Salariu");
                raspuns = sc.nextLine();

                Comparator<Employees> compPrenume = new Comparator<Employees>() {
                    @Override
                    public int compare(Employees o1, Employees o2) {

                        return o1.getFirstName().compareTo(o2.getFirstName());
                    }
                };
                Comparator<Employees> compNume = new Comparator<Employees>() {
                    @Override
                    public int compare(Employees o1, Employees o2) {

                        return o1.getLastName().compareTo(o2.getLastName());
                    }
                };
                Comparator<Employees> compSalar = new Comparator<Employees>() {
                    @Override
                    public int compare(Employees o1, Employees o2) {

                        return o1.getSalary() - o2.getSalary();
                    }
                };

                switch(raspuns){
                    case "1":{
                        employeesList.sort(compNume);
                        break;
                    }
                    case "2":{
                        employeesList.sort(compPrenume);
                        break;
                    }
                    case "3":{
                        employeesList.sort(compSalar);
                        break;
                    }
                    default:{
                        ok = false;
                        break;
                    }
                }
                System.out.println(employeesList);
            }
        }else{
            boolean ok = true;
            while (ok) {
                System.out.println("Ce Job Category vrei sa selectezi?");

                Query query = entityManager.
                        createQuery("Select j.name from JobCategories j");
                List<String> list = query.getResultList();

                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
                Scanner sc = new Scanner(System.in);
                String raspuns;
                raspuns = sc.nextLine();

                if (!list.contains(raspuns)) {
                    break;
                }

                query = entityManager.
                        createQuery("Select j from JobCategories j where j.name = :r");
                query.setParameter("r", raspuns);
                List<JobCategories> job = ((List<JobCategories>) query.getResultList());



                List<Employees> employeesList = job.get(0).getEmployees_list();

                System.out.println("Dupa ce criteriu vrei sa ordonezi lista?");
                System.out.println("1. Nume");
                System.out.println("2. Prenume");
                System.out.println("3. Salariu");
                raspuns = sc.nextLine();

                Comparator<Employees> compPrenume = new Comparator<Employees>() {
                    @Override
                    public int compare(Employees o1, Employees o2) {

                        return o1.getFirstName().compareTo(o2.getFirstName());
                    }
                };
                Comparator<Employees> compNume = new Comparator<Employees>() {
                    @Override
                    public int compare(Employees o1, Employees o2) {

                        return o1.getLastName().compareTo(o2.getLastName());
                    }
                };
                Comparator<Employees> compSalar = new Comparator<Employees>() {
                    @Override
                    public int compare(Employees o1, Employees o2) {

                        return o1.getSalary() - o2.getSalary();
                    }
                };

                switch(raspuns){
                    case "1":{
                        employeesList.sort(compNume);
                        break;
                    }
                    case "2":{
                        employeesList.sort(compPrenume);
                        break;
                    }
                    case "3":{
                        employeesList.sort(compSalar);
                        break;
                    }
                    default:{
                        ok = false;
                        break;
                    }
                }
                System.out.println(employeesList);
            }
        }

    }
    public static void main(String[] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();


        entityTransaction.begin();


        Meniu(entityManager);

        entityTransaction.commit();

        entityManager.close();
    }
}
