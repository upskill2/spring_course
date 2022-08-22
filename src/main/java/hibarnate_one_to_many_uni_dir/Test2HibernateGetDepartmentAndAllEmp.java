package hibarnate_one_to_many_uni_dir;

import hibarnate_one_to_many_uni_dir.entity.Department;
import hibarnate_one_to_many_uni_dir.entity.Employee;
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


            Department department = session.get(Department.class,18);

            System.out.println("PRINTED " + department);
            System.out.println(department.getEmployeesList());


            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

}
