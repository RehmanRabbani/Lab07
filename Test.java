package Person_info;
import java.util.List;
import org.apache.log4j.Logger;

public class Test {

    public final static Logger logger = Logger.getLogger(Test.class);
    
    public static void main(String[] args) {
    	
        Person studentObj1 = new Person(1, "Rehman","Rabbani","NUST","0301");
        
        Person studentObj2 = new Person(2, "Harry", "Potter", "Movie","0301");
        
        logger.info("\n=======CREATE RECORDS=======");

        DbOperations.createRecord(studentObj1);

        DbOperations.createRecord(studentObj2);

        logger.info("\n=======READ RECORDS=======");

        ListviewStudent = DbOperations.displayRecords();

        for(Person student : viewStudent) {

            logger.info(student.toString());

        }

        logger.info("\n=======UPDATE RECORDS=======");

        studentObj1.setpersonName("Salman");

        studentObj1.setfatherName("Rubbani");

       DbOperations.updateRecord(studentObj1);

        logger.info("\n=======READ RECORDS AFTER UPDATION=======");

        List updateStudent = DbOperations.displayRecords();

        for(Person student : updateStudent) {

            logger.info(student.toString());

        }

        logger.info("\n=======DELETE RECORD=======");

        DbOperations.deleteRecord(studentObj2.getStudentId());

        logger.info("\n=======READ RECORDS AFTER DELETION=======");

        List deleteStudentRecord = DbOperations.displayRecords();

        for(Person student : deleteStudentRecord) {

            logger.info(student.toString());

        }

        logger.info("\n=======DELETE ALL RECORDS=======");

        DbOperations.deleteAllRecords();

        logger.info("\n=======READ RECORDS AFTER ALL RECORDS DELETION=======");

        List deleteAll = DbOperations.displayRecords();

        for(Person student : deleteAll) {

            logger.info(student.toString());

        }

        System.exit(0);

    }

}
