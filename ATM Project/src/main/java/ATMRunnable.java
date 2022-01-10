import ATMAccounts.Accounts;
import Dispenser.Output;
import LocalBalance.Balance;

import java.util.ArrayList;
import java.util.Scanner;

//This is the beginning of the code

public class ATMRunnable {

    private static Balance balance = new Balance();
    private static Output moneyout = new Output();

    public static void main( String[] args){
        initialise();
    }

    public static void initialise(){
        ArrayList<Accounts> accountList = new ArrayList<Accounts>();
        Accounts account1 = new Accounts(800, 123456789, 1234, 200);
        Accounts account2 = new Accounts(1230, 987654321, 4321, 150);
        accountList.add(account1);
        accountList.add(account2);
        moneyout.setChecker(false);
        moneyout.setTodispense(0);
        moneyout.setBaseamount(0);

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your pin: ");
        int temppin = sc.nextInt();

        checkPin(temppin,accountList);

        if(!moneyout.getChecker()){
            Accounts tempaccount = new Accounts();
            requestProcessor(tempaccount);
            System.out.println("You have not entered an appropriate pin.");
        }

        if(moneyout.getChecker()&& moneyout.getTodispense()>0){
            System.out.println(outputCalculator(moneyout));
        }
        sc.close();

    }

    public static void checkPin(int temppin, ArrayList<Accounts> accountList){

        for(int j = 0; j < accountList.size(); j++){

            if(temppin == accountList.get(j).getPin()) {
                moneyout.setChecker(true);
                moneyout = requestProcessor(accountList.get(j));

            }
        }
    }

    public static Output requestProcessor(Accounts temp){
        Scanner sc = new Scanner(System.in);
        System.out.println("Select 1 for Balance" +
                "\n" + "Select 2 for Maximum Balance" +
                "\n" + "Select 3 for a withdrawal" +
                "\n" + "Select 4 to exit");
        int i = sc.nextInt();

        Output resultout = optionSwitch(i,temp);
        return resultout;
    }

    public static Output optionSwitch(int input, Accounts temp){
        Scanner sc = new Scanner(System.in);
        switch(input) {
            case 1:
                if(!moneyout.getChecker()){ break;}
                System.out.println("Your balance is: " + temp.getMybalance());
                break;
            case 2:
                if(!moneyout.getChecker()){ break;}
                System.out.println("Your Maximum allowed withdrawal is: " + (temp.getMybalance() + temp.getOverdraft()));
                break;
            case 3:
                if(!moneyout.getChecker()){
                    System.out.println("You cannot withdraw money without Having entered a pin");
                    break;
                }
                System.out.println("Enter the amount you would like to withdraw");

                int amount = sc.nextInt();
                if(amount < temp.getMybalance() + temp.getOverdraft() && amount < balance.getBalance()) {
                    Output tempout = new Output(amount);
                    tempout.setBaseamount(temp.getMybalance() + temp.getOverdraft() - amount);
                    tempout.setChecker(true);
                    sc.close();
                    return tempout;
                }else{
                    System.out.println("You have requested More funds than are available");
                    requestProcessor(temp);
                }
            case 4:
                break;
            default:
                System.out.println("An issue has occured");

        }
        sc.close();
        return moneyout;
    }

    public static String outputCalculator(Output moneyout){

        int tempmoney = moneyout.getTodispense();
        int [] bnotes = balance.getNotes();
        int [] mynotes = moneyout.getNotes();
        int [] denominations = new int[]{50,20,10,5};
        boolean unresolved = true;
        if(tempmoney%5 != 0) unresolved = false;


        while(unresolved){

            if(tempmoney <= 0) unresolved = false;

            for(int i = 0; i< bnotes.length;i++) {

                if(tempmoney/denominations[i] != 0){

                    if( 0 < bnotes[i] - tempmoney/denominations[i]){
                        bnotes[i] = bnotes[i] - tempmoney/denominations[i];
                        mynotes[i] = tempmoney/denominations[i];
                        tempmoney = tempmoney%denominations[i];
                    }
                }
            }
        }

        int total = ((mynotes[0]*50) + (mynotes[1]*20) + (mynotes[2]*10) + (mynotes[3]*5));

        String result = "You will recieve \n"
                + mynotes[0] + " 50 euro notes \n"
                + mynotes[1] + " 20 euro notes \n"
                + mynotes[2] + " 10 euro notes \n"
                + mynotes[3] + " 5 euro notes \n"
                + "\n" +  "Total: "
                + total
                + "\nYou have: " + moneyout.getBaseamount() + " available in your account";

        if(total == 0){
            result = "An Error Has Occured \n" + "The Amount of money you have requested is not supported by this ATM \n";
        }
        return result;
    }
}
