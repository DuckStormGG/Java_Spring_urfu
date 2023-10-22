package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsoleMain {
    public static void createEmploy(String name, String surname, String department,
                                    int salary, String city, String phoneNumber, String email) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();

            Employee employee = new Employee(name, surname, department, salary);
            Detail detail = new Detail(city, phoneNumber, email);

            employee.setEmpDetail(detail);

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
            System.out.println(">--------------------------Done!--------------------------<");
        } finally {
            session.close();
            factory.close();
        }
    }

    public static void showEmploy(int empId) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();

            session.beginTransaction();

            Employee employee = session.get(Employee.class, empId);
            System.out.println(">---------------------------------------------------------<");

            System.out.println(employee);
            session.getTransaction().commit();
            System.out.println(">--------------------------Done!--------------------------<");
        } finally {
            session.close();
            factory.close();
        }
    }

    public static void showDetail(int detailId) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();


            session.beginTransaction();

            Detail detail = session.get(Detail.class, detailId);
            System.out.println(">---------------------------------------------------------<");

            System.out.println(detail);
            session.getTransaction().commit();
            System.out.println(">--------------------------Done!--------------------------<");
        } finally {
            session.close();
            factory.close();
        }
    }

    public static void deleteEmploy(int empId) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();


            session.beginTransaction();
            Employee employee = session.get(Employee.class, empId);
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println(">--------------------------Done!--------------------------<");
        } finally {
            session.close();
            factory.close();
        }
    }
}
