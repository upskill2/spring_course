package hibarnate_one_to_many_bi;

import hibarnate_one_to_many_bi.entity.Department;
import hibarnate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test3HibernateGetlEmpDepartment {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {

            session = factory.getCurrentSession();
            session.beginTransaction();


            Employee emp = session.get(Employee.class,1);

            System.out.println(emp);
            System.out.println(emp.getDepartment());

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

}
