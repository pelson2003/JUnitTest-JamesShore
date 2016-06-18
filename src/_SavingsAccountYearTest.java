import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class _SavingsAccountYearTest {

//	@Test
//	public void depositandWithdrawl() {
//		SavingAccountYear account = new SavingAccountYear();
//		account.deposit(100);
//		assertEquals("after deposit", 100, account.balance());
//		account.withdraw(50);
//		assertEquals("after withdrawal", 50, account.balance());
//	}
	
//	@Test
//	public void negativeBalanceisJustFine() {
//		SavingAccountYear account = new SavingAccountYear();
//		account.withdraw(75);
//		assertEquals(-75, account.balance());
//	}
	
	private SavingAccountYear newAccount() {
		SavingAccountYear account = new SavingAccountYear(10000, 10);
		return account;
	}
	
	
	
	@Test
	public void startingBalanceMatchesConstructor(){
		assertEquals(10000, newAccount().startingBalance());
	}

	@Test
	public void endingBalanceAppliesInterestRate() {
		assertEquals(11000, newAccount().endingBalance(25));	
	}

	@Test
	public void interestRateAppliesInterestRate(){
		assertEquals(11000, newAccount().endingBalance(25));
	}
	
	@Test
	public void nextYearStartingBalanceShouldEqualThisYearsEndingBalance() {
		SavingAccountYear thisYear = newAccount();
		assertEquals(thisYear.endingBalance(25), thisYear.nextYear(25).startingBalance());	
	}
	
	@Test
	public void nextYearInteresetRateEqualsThisYearInteresetRate(){
		SavingAccountYear thisYear = newAccount();
		assertEquals(thisYear.interestRate(), thisYear.nextYear(25).interestRate());
	}
	
	@Test
	public void withdrawFundsBeginningatTheEndofTheYear() {
		SavingAccountYear year = new SavingAccountYear(10000,10);
		year.withdraw(1000);
		assertEquals(9900, year.endingBalance(25));
	}
	
	@Test 
		public void startingPrincipa(){
		SavingAccountYear year = new SavingAccountYear(10000,3000, 10);
		assertEquals(3000, year.startingPrincipal());
	}
	
	@Test 
		public void endingPrincipa(){
		SavingAccountYear year = new SavingAccountYear(10000,3000, 10);
		year.withdraw(2000);
		assertEquals("Ending Princiapl: ", 1000, year.endingPrincipal());
	}
	
	@Test
	public void endingPrinciaplNeverGoesBelowZero(){
		SavingAccountYear year = new SavingAccountYear(10000,3000, 10);
		year.withdraw(4000);
		assertEquals("Ending Princiapl: ", 0, year.endingPrincipal());
	}
	
	@Test
		public void multipleWithdrawlsInaYear(){ 
		SavingAccountYear year = new SavingAccountYear(10000,10);
		year.withdraw(1000);
		year.withdraw(2000);
		assertEquals(3000, year.totalWithdrawals());
	}
	
	@Test
	public void capitalGainsTaxIncurred_NeedstoCoverCapitalGainsWithdrawns_andAdditionalCapitalGainsWithdrawmtoPayCapitalGainTax(){
		SavingAccountYear year = new SavingAccountYear(10000, 3000, 10);
		year.withdraw(5000);
		assertEquals(2000, year.capitalGainsWithdrawn());
		assertEquals(666, year.capitalGainTaxIncurred(25));
	}
	
	@Test
	public void capitalGainsWithdrawn() {
		SavingAccountYear year = new SavingAccountYear(10000,3000, 10);
		year.withdraw(1000);
		assertEquals(0, year.capitalGainsWithdrawn());
		year.withdraw(3000);
		assertEquals(1000, year.capitalGainsWithdrawn());
	}
	
	@Test
	public void capitalGainsTaxIsIncludedinEndingBalance(){
		SavingAccountYear year = new SavingAccountYear(10000, 3000, 10);
		int amountWithdrawn = 5000;
		year.withdraw(amountWithdrawn);
		int expectedCapitalGainsTax = 666;
		assertEquals(expectedCapitalGainsTax, year.capitalGainTaxIncurred(25));
		int expectedStartingBalancedAfterWithdrawals = 10000 - amountWithdrawn - expectedCapitalGainsTax;
		
		assertEquals((int)(expectedStartingBalancedAfterWithdrawals * 1.10), year.endingBalance(25));
	}
	
	
//	@Test
//	public void withdrawingMoreThanPrincipalIncursCapitalGainsTax(){
//		SavingAccountYear year = new SavingAccountYear(10000,3000, 10);
//		year.withdraw(3000);
//		assertEquals(7700, year.endingBalance());	
//		year.withdraw(5000);
//		assertEquals(2000 + 200 - (1250), year.endingBalance());
//	}
	
	
}
