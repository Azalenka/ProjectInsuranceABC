package projectInsuranceABC.dao;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import projectInsuranceABC.beans.Client;
import projectInsuranceABC.beans.PayData;

import java.util.Date;
@Ignore
public class PayDataDAoTest extends TestCase {

    private static final Client client= new Client(1,"test","test","test");
    private  static final String targetAccountTest= "102";
    private static  final int sumTest= 103;
    private static final Date dataTest= new Date();


    private PayDataDAo payDataDAO;
     private PayData payData;


    @Before
    public void prepareDoInsert(){
        payDataDAO= new PayDataDAo();
        payData= new PayData(client,targetAccountTest,sumTest,dataTest);

    }

    @Test
public void doInsertTest(){
payDataDAO.insert(payData);

    }
}