package hibernate_multi_table;

import hibernate_multi_table.entity.Detail;
import hibernate_multi_table.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2HibernateSelectById {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);

            session.delete(employee);

         //   System.out.println("PRINT + " + employee.getEmpDetail());


            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

}
