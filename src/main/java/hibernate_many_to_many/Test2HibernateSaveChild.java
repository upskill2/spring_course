package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2HibernateSaveChild {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();

            Child child1 = new Child("child4", 131);

            Section section2 = new Section("section2");
            Section section3 = new Section("section3");
            Section section4 = new Section("section4");

            child1.addSectionToChild(section2);
            child1.addSectionToChild(section3);
            child1.addSectionToChild(section4);

            session.beginTransaction();

            //logic below
            session.save(child1);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();

        }

    }

}
