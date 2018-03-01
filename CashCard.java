package atm;

public class CashCard {
	private int cardNum;
	private int expMonth;
	private int expYear;
	final String bankA = "A";
	final String bankB = "B";
	public static int idA = 101;
	public static int idB = 201;
	
	/**
	 * Constructor for CashCard object
	 * @param bankID	The letter of the bank that the card belongs to
	 * @param currentMo	The month that the card was created
	 * @param currentYr	The year that the card was created
	 */
	public CashCard(String bankID, int currentMo, int currentYr){
		if(bankID.equals(bankA)){
			cardNum = idA;
			idA += 2;
		}
		if(bankID.equals(bankB)){
			cardNum = idB;
			idB += 2;
		}
		expMonth = currentMo;
		expYear = currentYr + 4;
	}
	
	/**
	 * Returns card number
	 * @return int card number
	 */
	public int getCardNum(){
		return cardNum;
	}
	
	/**
	 * Returns month of expiration
	 * @return int expiration month
	 */
	public int getExpMonth(){
		return expMonth;
	}
	
	/**
	 * Returns year of expiration
	 * @return int expiration year
	 */
	public int getExpYear(){
		return expYear;
	}

}
