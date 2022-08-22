package hibarnate_one_to_many_uni_dir;


import hibarnate_one_to_many_uni_dir.entity.Department;
import hibarnate_one_to_many_uni_dir.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test5HibernateDeleteDepartment {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {

            session = factory.getCurrentSession();
            session.beginTransaction();


            Department dep = session.get(Department.class,18); //emp 3-4 id 9-10


            session.delete(dep);

            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }

}
