
public class SavingAccountYear {

	private int startingBalance = 0;
	private int interestRate = 0;
	private int capitalGainsAmount = 0;
	private int totalWithdraw = 0;
	private int startingPrincipal;

	public SavingAccountYear() {
	}

	public SavingAccountYear(int staringBalance, int interestRate) {
		this.startingBalance = staringBalance;
		this.interestRate = interestRate;
	}

	public SavingAccountYear(int staringBalance, int startingPrincipal, int interestRate) {
		this.startingBalance = staringBalance;
		this.startingPrincipal = startingPrincipal;
		this.capitalGainsAmount = staringBalance - startingPrincipal;
		this.interestRate = interestRate;
	}

	public SavingAccountYear nextYear(int capitalGainsTaxRate) {
		return new SavingAccountYear(this.endingBalance(capitalGainsTaxRate), this.interestRate);
	}

	public int endingBalance(int capitalGainsTaxRate) {
		// TODO Auto-generated method stub
		int modifiedStart = startingBalance - totalWithdraw - capitalGainTaxIncurred(capitalGainsTaxRate);
		return modifiedStart + ((modifiedStart * interestRate) / 100);
	}

	public int startingBalance() {
		// TODO Auto-generated method stub
		return startingBalance;
	}

	public int interestRate() {
		return interestRate;
	}

	public void withdraw(int amount) {
		// startingBalance -= amount;
		this.totalWithdraw += amount;
	}

	public int startingPrincipal() {
		return startingBalance - capitalGainsAmount;
	}

	public int endingPrincipal() {
		// TODO Auto-generated method stub
		int result = startingPrincipal() - totalWithdraw;
		return Math.max(0, result);
		// return (result < 0) ? 0 : result;
		
	}

	public int totalWithdrawals() {
		// TODO Auto-generated method stub
		return totalWithdraw;
	}

	public int capitalGainsWithdrawn() {
		int result = -1 * (startingPrincipal() - totalWithdrawals());
		//return (result < 0) ? 0 : result;
		return Math.max(0, result);
	}

	public int capitalGainTaxIncurred(int taxRate) {
		double dblTaxRate = taxRate / 100.0;
		double dblCapGains = capitalGainsWithdrawn();
		return (int)((dblCapGains / (1 - dblTaxRate )) - dblCapGains);
	}
	
	

}
