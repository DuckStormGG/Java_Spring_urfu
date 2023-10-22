package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try{
            session = factory.getCurrentSession();
//            Employee employee = new Employee("Pavel", "Ahaimov","IT", 500 );
//            Detail detail = new Detail("Ekb", "88005553535", "pavel.ahaimov@urfu.me");
//            employee.setEmpDetail(detail);
            session.beginTransaction();
            Employee emp = session.get(Employee.class, 1);
            session.delete(emp);
            session.getTransaction().commit();
            System.out.println(">--------------------------Done!--------------------------<");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
