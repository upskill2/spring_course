package hibarnate_one_to_many_bi;

import hibarnate_one_to_many_bi.entity.Department;
import hibarnate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2HibernateGetDepartmentAndAllEmp {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("-----------------------------");

            Department department = session.get(Department.class, 19);

            System.out.println("-----------------------------");
            System.out.println("PRINT Dpt" + department);

            department.getEmployeesList().get(0);

            session.getTransaction().commit();

            System.out.println("-----------------------------");
            System.out.println("PRINT empl " + department.getEmployeesList());

        } finally {
            session.close();
            factory.close();
        }
    }

}
