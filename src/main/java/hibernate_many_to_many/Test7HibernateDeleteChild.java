package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test7HibernateDeleteChild {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();

            session.beginTransaction();

            //logic below
            Child child = session.get(Child.class, 5);

            session.delete(child);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();

        }

    }

}
