package AP.Lab7;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.Person;

public class DbHandler {
    public final static Logger logger = Logger.getLogger(DbHandler.class);
    public static SessionFactory getSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File

        Configuration configObj = new Configuration();

        configObj.configure("hibernate.xml");


        // Since Hibernate Version 4.x, Service Registry Is Being Used

        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();


        // Creating Hibernate Session Factory Instance

        SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);

        return factoryObj;

    }


    // Method 1: This Method Used To Create A New Student Record In The Database Table

    public static Integer createRecord(Person studentObj) {

        Session sessionObj = getSessionFactory().openSession();

        //Creating Transaction Object
        Transaction transObj = sessionObj.beginTransaction();

        sessionObj.save(studentObj);

        // Transaction Is Committed To Database

        transObj.commit();



        // Closing The Session Object
        sessionObj.close();
        logger.info("Successfully Created " + studentObj.toString());

        return studentObj.getpersonId();

    }



    // Method 2: This Method Is Used To Display The Records From The Database Table

    @SuppressWarnings("unchecked")

    public static List displayRecords() {

        Session sessionObj = getSessionFactory().openSession();

        List personList = sessionObj.createQuery("FROM Student").list();



        // Closing The Session Object

        sessionObj.close();

        logger.info("Student Records Available In Database Are?= " + personList.size());

        return personList;

    }



    // Method 3: This Method Is Used To Update A Record In The Database Table

    public static void updateRecord(Person personObj) {

        Session sessionObj = getSessionFactory().openSession();



        //Creating Transaction Object

        Transaction transObj = sessionObj.beginTransaction();

        Person perObj = sessionObj.load(Person.class, personObj.getpersonId());

        perObj.setpersonName(personObj.getpersonName());

        perObj.setfatherName(personObj.getfatherName());

        // Transaction Is Committed To Database

        transObj.commit();

        // Closing The Session Object

        sessionObj.close();
        logger.info("Student Record Is Successfully Updated!= " + personObj.toString());

    }



    // Method 4(a): This Method Is Used To Delete A Particular Record From The Database Table

    public static void deleteRecord(Integer personId) {

        Session sessionObj = getSessionFactory().openSession();


        //Creating Transaction Object

        Transaction transObj = sessionObj.beginTransaction();

        Person perObj = findRecordById(personId);

        sessionObj.delete(perObj);



        // Transaction Is Committed To Database

        transObj.commit();

        // Closing The Session Object

        sessionObj.close();

        logger.info("Successfully Record Is Successfully Deleted!=  " + perObj.toString());
   }

    // Method 4(b): This Method To Find Particular Record In The Database Table
    public static Person findRecordById(Integer personId) {
        Session sessionObj = getSessionFactory().openSession();

        Person per = sessionObj.load(Person.class, personId);
        // Closing The Session Object
        sessionObj.close();
        return per;
    }
}
