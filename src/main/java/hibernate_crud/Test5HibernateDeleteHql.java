package hibernate_crud;

import hibernate_crud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test5HibernateDeleteHql {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class,48);
            session.delete(emp);

            //
            session.createQuery("delete Employee " + "where name = 'name1'").executeUpdate();

            //simple setter


            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }

}
