package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test3HibernateSelectHql {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> empList = session.createQuery("from Employee " + "where name='Name3' AND salary=1900").getResultList();

            for (Employee em : empList) {
                System.out.println("PRINTED " + em);
                
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
        }


    }
}
