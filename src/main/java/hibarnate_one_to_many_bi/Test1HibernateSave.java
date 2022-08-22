package hibarnate_one_to_many_bi;

import hibarnate_one_to_many_bi.entity.Department;
import hibarnate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1HibernateSave {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {

            session = factory.getCurrentSession();


            Department department = new Department("IT", 300, 500);

            Employee emp1 = new Employee("Emp3", "SurName",5000);
            Employee emp2 = new Employee("Emp4", "Swery",3500);

            department.addEmployeeTopDepartment(emp1);
            department.addEmployeeTopDepartment(emp2);

            session.beginTransaction();
            session.save(department);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

}
