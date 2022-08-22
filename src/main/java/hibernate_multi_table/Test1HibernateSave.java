package hibernate_multi_table;

import hibernate_multi_table.entity.Detail;
import hibernate_multi_table.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1HibernateSave {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Name1", "Bro", "IT", 300);
            Detail detail = new Detail("Kyiv", 380, "@gmail");
            session.beginTransaction();

            employee.setEmpDetail(detail);

            session.save(employee);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }


    }
}
