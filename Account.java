
package atm;
public class Account {
	private int accountNum;
	private CashCard card;
	private String password;
	private int balance;
	
	/**
	 * Constructor for Account object passes through account information
	 * @param bankID The id of the bank that the account belongs to
	 * @param month	The month the account was opened
	 * @param year	The year the account was opened
	 * @param pw	The password for the account
	 * @param balance	The amount of money stored within the account
	 */
	public Account(String bankID, int month, int year, String pw, int balance){
		card = new CashCard(bankID, month, year);
		accountNum = card.getCardNum();
		this.balance = balance;
		password = pw;
	}
	
	/**
	 * Returns account password
	 * @return string password
	 */
	public String getPass(){
		return password;
	}
	
	/**
	 * Returns the CashCard object associated with the account
	 * @return the CashCard of the account
	 */
	public CashCard getCard(){
		return card;
	}
	
	/**
	 * Returns account number
	 * @return int account number
	 */
	public int getAccountNumber(){
		return this.accountNum;
	}
	
	/**
	 * Returns account balance
	 * @return int balance
	 */
	public int getBalance(){
		return balance;
	}
	
	/**
	 * Changes the balance of the account
	 * @param amount the amount of money withdrawn from the account
	 */
	public void withdrawBalance(int amount){
		balance = balance - amount;
	}
	
	
	
	
}
