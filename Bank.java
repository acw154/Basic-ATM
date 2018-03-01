package atm;
import java.util.*;

public class Bank {
	public ArrayList<Account> accounts;
	public ArrayList<ATM> atms;
	String bankID;
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Constructor for Bank object
	 * @param id The Letter A or B that identifies which bank it is
	 * @param max1 the Max withdraw for atm 1
	 * @param max2 the max withdraw for atm2
	 */
	public Bank(String id, int max1, int max2){
		bankID = id;
		accounts = new ArrayList<Account>();
		atms = new ArrayList<ATM>();
		ATM atm1 = new ATM("ATM1_" + id, accounts, max1);
		ATM atm2 = new ATM("ATM2_" + id, accounts, max2);
		atms.add(atm1);
		atms.add(atm2);
	}
	
	/**
	 * Verifies if card belongs to an account
	 * @param number
	 * @return
	 */
	public boolean checkCard(int number){
		for(Account a: accounts){
			if(a.getAccountNumber() == (number)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns ArrayList containing accounts stored in the bank
	 * @return ArrayList<Account> accounts
	 */
	public ArrayList<Account> getAccounts(){
		return accounts;
	}
	
	/**
	 * Adds account object to accounts ArrayList
	 * @param acc account object
	 */
	public void addAccount(Account acc){
		accounts.add(acc);
	}
	
	/**
	 * Prompts user for atm choice and checks if input is consistent with possible atm choices
	 */
	public void run(){
		String quitInput = "quit";
		ATM correctATM = null;
		String atmChoice = "";
		while(atmChoice != "1" || atmChoice != "2" || atmChoice != quitInput){
			System.out.println("Please enter your ATM choice: 1 or 2. At any point type 'quit' to exit" );
			atmChoice = sc.nextLine();
			if(atmChoice.equals(quitInput)){
				System.out.println("Returning");
				return;
			}
			if(!atmChoice.equals("1") && !atmChoice.equals("2")){
				System.out.println("Incorrect ATM choice");
			} else{
				for(ATM atm: atms){
					if(atm.getName().equals("ATM" + atmChoice + "_" + bankID)){
						correctATM = atm;
						correctATM.runVerify();
						//from here we can have correctATM run to find account and run from there
					}
				}
			}
		}
		
		
		
		
		
		
		
	}
	
		
	
}
