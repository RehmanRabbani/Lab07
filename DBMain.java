package AP.Lab7;

import org.apache.log4j.Logger;

import com.hibernate.Person;

public class DBMain {

    public final static Logger logger = Logger.getLogger(DBMain.class);

    public static void main(String[] args) {

        Person studentObj1 = new Person(1, "Rehman","Rabbani","NUST","0301");

        Person studentObj2 = new Person(2, "Harry", "Potter", "Movie","0301");

        logger.info("\n=======CREATE RECORDS=======");

        DbHandler.createRecord(studentObj1);

        DbHandler.createRecord(studentObj2);

        logger.info("\n=======UPDATE RECORDS=======");

        studentObj1.setpersonName("Salman");

        studentObj1.setfatherName("Rubbani");

       DbHandler.updateRecord(studentObj1);

        logger.info("\n=======DELETE RECORD=======");

        DbHandler.deleteRecord(studentObj2.getpersonId());

        System.exit(0);

    }

}

