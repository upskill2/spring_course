package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2HibernateSelectById {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Name4", "Sister", "Sales", 900);

            session.beginTransaction();
            session.save(employee);
//            session.getTransaction().commit();

            int myId = employee.getId();
 //           session = factory.getCurrentSession();
//            session.beginTransaction();

            Employee emp = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println("PRINTED + " + emp);




        } finally {
            factory.close();
        }


    }
}
