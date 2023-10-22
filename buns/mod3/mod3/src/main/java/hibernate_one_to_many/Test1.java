package hibernate_one_to_many;


import hibernate_one_to_many.entity.Department;
import hibernate_one_to_many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try{
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Department department = new Department("IT", 300, 1200);
//            Employee employee1 = new Employee("Zaur", "Trugulov", 800);
//            Employee employee2 = new Employee("Pave", "Ahaimov", 100);
//
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//
//            session.save(department);
//
//            session.getTransaction().commit();
//            System.out.println(">--------------------------Done!--------------------------<");

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Department department = session.get(Department.class, 1);
//
//            System.out.println(department);
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();
////            System.out.println(">--------------------------Done!--------------------------<");
//
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee employee = session.get(Employee.class, 1);
//
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//            System.out.println(">--------------------------Done!--------------------------<");

            session = factory.getCurrentSession();

            session.beginTransaction();

            Employee employee = session.get(Employee.class, 4);

            session.delete(employee);

            session.getTransaction().commit();
            System.out.println(">--------------------------Done!--------------------------<");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
