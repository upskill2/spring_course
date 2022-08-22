package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test6HibernatePersistSection {

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

            Section section1 = new Section("section1");

            //logic below


            Child child1 = new Child("child6", 3);
            Child child2 = new Child("child7", 15);
            Child child3 = new Child("child8", 1);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.persist(section1);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();

        }

    }

}
