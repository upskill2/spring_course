package hibernate_multi_table;

import hibernate_multi_table.entity.Detail;
import hibernate_multi_table.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test4HibernateOneToOneInGetDetails {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 3);

            session.delete(detail);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

}
