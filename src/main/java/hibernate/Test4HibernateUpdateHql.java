package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test4HibernateUpdateHql {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            //simple setter
            Employee emp = session.get(Employee.class, 48);
            emp.setSalary(666);

            //query with parameters
            session.createQuery("update Employee set salary=1500 " + "where name='Name4'").executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }


    }
}
