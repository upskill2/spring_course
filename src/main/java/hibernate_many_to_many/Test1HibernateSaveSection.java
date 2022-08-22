package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class Test1HibernateSaveSection {

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
            session.save(section1);


            Child child1 = new Child("child1", 3);
            Child child2 = new Child("child2", 15);
            Child child3 = new Child("child3", 1);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.save(child1);
            session.save(child2);
            session.save(child3);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();

        }

    }

}
