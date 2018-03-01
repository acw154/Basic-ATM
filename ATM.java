package atm;
import java.util.*;

public class ATM{
	public int maxWithdraw;
	public String ATMName;
	ArrayList<Account> accountList = new ArrayList<Account>();
	Scanner sc = new Scanner(System.in);
	final String quitInput = "quit";
	
	/**
	 * ATM constructor passes through String name, and the Bank's ArrayList of accounts
	 * @param name Name of the ATM
	 * @param bankAccounts Accounts stored in the Bank
	 * @param max the max withdraw for the atm
	 */
	public ATM(String name, ArrayList<Account> bankAccounts, int max){
		accountList = bankAccounts;
		ATMName = name;
		maxWithdraw = max;
	}
	
	/**
	 * Returns the maximum withdrawal amount of the ATM
	 * @return the maximum withdrawal amount (int)
	 */
	public int getMax(){
		return maxWithdraw;
	}
	
	/**
	 * Returns the name of the ATM
	 * @return the name of the ATM (string)
	 */
	public String getName(){
		return ATMName;
	}
	
	/**
	 * Prompts user for card and checks if card and therefore account exist within the bank's storage of accounts
	 */
	public void runVerify(){
		//check if card exists
		boolean expired = false;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int day =  Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		Account correct = null;
		boolean accepted = false;
		while(!accepted){
		System.out.println("Enter your card. Example card: A123");
		String cardInfo = sc.nextLine();
		if(cardInfo.equals(quitInput)){
			System.out.println("Quitting application");
			break;
		}
		String bankID = this.getName().substring(5,6);
		if(cardInfo.substring(0, 1).equals(bankID)){
			
			for(Account a: accountList){
				if(Integer.toString(a.getAccountNumber()).equals(cardInfo.substring(1))){
					correct = a;
					if(!(correct.getCard().getExpYear() > year && correct.getCard().getExpMonth() < month)){
						System.out.println("This card is expired. Please enter a correct card or quit");
						correct = null;
						expired = true;
						
					} else {
							System.out.println("This card is accepted.");
							accepted = true;
						
					}
					
				}
			}
			if(correct == null && expired == false){
				System.out.println("This account does not exist");
			} else if(correct != null){
				this.verifyPassword(correct);
			}
		} else {
			System.out.println("This card is not supported by this ATM");
		}
		}
	}
	
	/**
	 * Prompts user for account password and verifies
	 * @param a the account being verified
	 */
	public void verifyPassword(Account a){
		String inputPass;
		boolean pwAccept = false;
		while(!pwAccept){
		System.out.println("Please enter your password");
		inputPass = sc.nextLine();
		if(inputPass.equals(a.getPass())){
			this.runTransaction(a);
			pwAccept = true;
		} else if (inputPass.equals(quitInput)){
			System.out.println("Returning");
			break;
		} else {
			System.out.println("This is a wrong password. Reenter a password or type 'quit' to quit");
		}
	}
	}
	
	/**
	 * Prompts user for withdrawal amount and checks if amount is possible
	 * @param a the account undergoing the transaction
	 */
	public void runTransaction(Account a){
		String withdrawAmt;
		boolean amtAccept = false;
		while(!amtAccept){
			System.out.println("Please enter the amount of money you would like to withdraw. This ATM has a max Withdrawal amount of " + this.getMax());
			withdrawAmt = sc.nextLine();
			if(withdrawAmt.equals(quitInput)){
				System.out.println("Returning");
				break;
			}
			if(Integer.parseInt(withdrawAmt) > this.getMax()){
				System.out.println("This amount either exceeds the max amount of money that you can withdraw from this ATM. Please enter a new amount or quit");
				
			} else if(Integer.parseInt(withdrawAmt) > a.getBalance()){
					System.out.println("This amount exceeds the current balance of your account. Enter another amount or quit");
			} else{
					a.withdrawBalance(Integer.parseInt(withdrawAmt));
					System.out.println(withdrawAmt + " has been withdrawn from your account. Your new balance is " + a.getBalance());
					System.out.println("Returning");
					amtAccept = true;
					
			}
		}
	
	}
	
}		
				
				
			
