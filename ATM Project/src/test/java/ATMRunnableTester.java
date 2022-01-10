import ATMAccounts.Accounts;
import Dispenser.Output;
import LocalBalance.Balance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ATMRunnableTester {

    @Test
    @DisplayName("Before all other tests")
    public void beforeAll(){
        System.out.println("This is the Start of the tests");
    }

    @Test
    public void TestOutputCalculator() throws Throwable{
        ATMRunnable instanceOfRun = new ATMRunnable();

        Output outputInstance = new Output();
        outputInstance.setTodispense(50);
        outputInstance.setBaseamount(1330);
        outputInstance.setChecker(true);

        String actualvalue = instanceOfRun.outputCalculator(outputInstance);
        String expectedvalue = "You will recieve \n"
                + 1 + " 50 euro notes \n"
                + 0 + " 20 euro notes \n"
                + 0 + " 10 euro notes \n"
                + 0 + " 5 euro notes \n"
                + "\n" +  "Total: "
                + 50
                + "\nYou have: " + 1330 + " available in your account";

        assertEquals(actualvalue, expectedvalue);
    }

    @Test
    public void TestOutputCalculatorWrong() throws Throwable{
        ATMRunnable instanceOfRun = new ATMRunnable();

        Output outputInstance = new Output();
        outputInstance.setTodispense(34);
        outputInstance.setBaseamount(1330);
        outputInstance.setChecker(true);

        String actualvalue = instanceOfRun.outputCalculator(outputInstance);
        String expectedvalue = "You will recieve \n"
                + 1 + " 50 euro notes \n"
                + 0 + " 20 euro notes \n"
                + 0 + " 10 euro notes \n"
                + 0 + " 5 euro notes \n"
                + "\n" +  "Total: "
                + 34
                + "\nYou have: " + 1330 + " available in your account";

        assertNotEquals(actualvalue, expectedvalue);
    }

    @Test
    public void TestAccount() throws Throwable{

        Accounts account1 = new Accounts(800, 123456789, 1234, 200);
        Accounts actualvalue = account1;

        Accounts account2 = new Accounts();
        account2.setMybalance(800);
        account2.setOverdraft(200);
        account2.setName(123456789);
        account2.setPin(1234);
        Accounts expectedvalue = account2;

        assertEquals(actualvalue.toString(), expectedvalue.toString());
    }

    @Test
    public void TestBalance() throws Throwable{

        Balance balance1 = new Balance();
        Balance actualvalue = balance1;

        Balance balance2 = new Balance();
        int[] notes = new int[]{10,30,30,20};
        balance2.setBalance(1500);
        balance2.setNotes(notes);
        Balance expectedvalue = balance2;

        assertEquals(actualvalue.toString(), expectedvalue.toString());
    }

    @Test
    public void TestOutput() throws Throwable{

        Output output1 = new Output(300);
        Output actualvalue = output1;

        Output output2 = new Output();
        output2.setTodispense(300);
        Output expectedvalue = output2;

        assertEquals(actualvalue.toString(), expectedvalue.toString());
    }

    @Test
    @DisplayName("After all other tests")
    public static void afterAll(){
        System.out.println("This is the End of the tests");
    }

}
