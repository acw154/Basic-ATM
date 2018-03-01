package atm;
import java.util.*;
public class ATMSystem {
	 

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int countA = 1;
		int countB = 1;
		String bankChoice = "";
		Bank bankA = new Bank("A", 40, 50);
		Bank bankB = new Bank("B", 35, 45);
		Account acc1 = new Account("A", 9, 2017, "snake", 70);
		Account acc2 = new Account("A", 4, 2011, "dog", 40);
		Account acc3 = new Account("A", 7, 2016, "rat", 49);
		Account acc4 = new Account("B", 9, 2017, "cow", 0);
		Account acc5 = new Account("B", 7, 2013, "mouse", 99);
		Account acc6 = new Account("B", 8, 2010, "dragon", 51);
		bankA.addAccount(acc1);
		bankA.addAccount(acc2);
		bankA.addAccount(acc3);
		bankB.addAccount(acc4);
		bankB.addAccount(acc5);
		bankB.addAccount(acc6);
		System.out.println("---------------------------------------------------------");
		for(Account a: bankA.accounts){
			System.out.println("Bank A Account " + countA + " Number: " + a.getAccountNumber() + " Password: " + a.getPass() + ", Balance: " + a.getBalance() + ", Exp Date: " + a.getCard().getExpMonth() + " / " + a.getCard().getExpYear());
			countA++;
		}
		for(ATM atm: bankA.atms){
			System.out.println(atm.getName() + " Max Withdrawal: " + atm.getMax());
		}
		System.out.println("---------------------------------------------------------");
		for(Account b: bankB.accounts){
			System.out.println("Bank B Account " + countB + " Number: " + b.getAccountNumber() + " Password: " + b.getPass() + ", Balance: " + b.getBalance() + ", Exp Date: " + b.getCard().getExpMonth() + " / " + b.getCard().getExpYear());
			countB++;
		}
		for(ATM atm: bankB.atms){
			System.out.println(atm.getName() + " Max Withdrawal: " + atm.getMax());
		}
		System.out.println("---------------------------------------------------------");
		
		
		while(bankChoice != "A" || bankChoice != "B" || bankChoice != "quit"){
			System.out.println("Please enter your choice of Bank. A or B");
			bankChoice = sc.nextLine();
			if(bankChoice.equals("A")){
			bankA.run();
			}
			if(bankChoice.equals("B")){
			bankB.run();
			}
			if(bankChoice.equals("quit")){
			System.out.println("Application close");
			break;
			}
		}
		}
	
}
