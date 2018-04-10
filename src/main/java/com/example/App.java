package com.example;

import com.example.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "test" );
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();

        Employee employee = new Employee();
        employee.setName("Jack");

        Employee employee2 = new Employee();
        employee2.setName("John");

        entityManager.persist(employee);
        entityManager.persist(employee2);

        entityManager.getTransaction().commit();

        Query query = entityManager.createQuery("Select e from Employee e");

        List<Employee> resultList = query.getResultList();

        resultList.forEach(System.out::println);

        entityManager.close();
        emfactory.close();

        System.out.println("Done");
    }
}
