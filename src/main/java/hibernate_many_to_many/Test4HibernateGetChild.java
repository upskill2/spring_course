package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4HibernateGetChild {

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
           Child child = session.get(Child.class,3);

            System.out.println("Print section " + child);
            System.out.println("Print children in section " + child.getSectionList());

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();

        }

    }

}
