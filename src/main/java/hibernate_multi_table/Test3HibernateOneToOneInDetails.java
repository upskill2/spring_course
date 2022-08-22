package hibernate_multi_table;

import hibernate_multi_table.entity.Detail;
import hibernate_multi_table.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test3HibernateOneToOneInDetails {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();
            session.beginTransaction();

            Employee employee = new Employee("Name2", "BroS", "sales", 500);
            Detail detail = new Detail("Nemyr", 389, "@ukr.net");


            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.save(detail);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

}
