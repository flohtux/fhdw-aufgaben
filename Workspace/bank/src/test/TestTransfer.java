/**
 * TODOS unter https://notes.selent.me/p/TODO_IIS
 */

package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import model.Administrator;
import model.Amount;
import model.BankCreator;
import model.DebitException;
import model.Dollar;
import model.Euro;
import model.ExecuteException;
import model.FixTransactionFee;
import model.InvalidAccountNumberException;
import model.InvalidBankNumberException;
import model.Limit;
import model.LimitAccount;
import model.DebitException;
import model.MixedFee;
import model.Money;
import model.NoPermissionToExecuteDebitTransferException;
import model.Percent;
import model.Pfund;
import model.ProcentualFee;
import model.SuccessfulState;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAdministrator;
import persistence.PersistentBank;
import persistence.PersistentFixTransactionFee;
import persistence.PersistentLimitAccount;
import persistence.PersistentMoney;
import persistence.PersistentProcentualFee;
import persistence.PersistentSuccessfulState;
import persistence.PersistentTransfer;
import common.Fraction;

public class TestTransfer {

	private final String BankName1 = "Bank1";
	private final String BankName2 = "Bank2";
	private final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
	private final long SecondAccountNumber = FirstAccountNumber + 1;

	@Before
	public void setUpDatabase() {
		try {
			TestSupport.prepareDatabase(); // TODO PREREQUISITES: Test:
			// substitute by following statement
			// for database-less test:
			// ConnectionHandler.getTheConnectionHandler().connect("localhost:1521:xe",
			// "bank", "bank", "pg".toCharArray(), false);
			TestSupport.prepareSingletons();
			persistence.Cache.getTheCache().reset$For$Test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void assertMoneyEquals(PersistentMoney a, PersistentMoney b) throws PersistenceException {
		assertEquals(a.getAmount().getBalance(), b.getAmount().getBalance());
		assertEquals(a.getCurrency(), b.getCurrency());
	}

	@Test
	public void testBankintern() throws PersistenceException, ExecuteException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(SecondAccountNumber);
		newTrans.setReceiverBankNumber(bank.getBankNumber());
		newTrans.execute();

		assertEquals(new Fraction(10, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(-10, 1), acc1.getMoney().getAmount().getBalance());
		assertEquals(SuccessfulState.createSuccessfulState(), newTrans.getState());

	}

	@Test
	public void testBankinternOtherCurrencies() throws PersistenceException, ExecuteException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Dollar.getTheDollar()));
		newTrans.setReceiverAccountNumber(SecondAccountNumber);
		newTrans.setReceiverBankNumber(bank.getBankNumber());
		newTrans.execute();

		assertEquals(new Fraction(10, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(-10, 1), acc1.getMoney().getAmount().getBalance());
		assertTrue(newTrans.getState() instanceof PersistentSuccessfulState);

	}

	@Test
	public void testLimits() throws PersistenceException, ExecuteException {
		PersistentAdministrator adminTestLimits = Administrator.createAdministrator();

		PersistentBank bankTestLimits = BankCreator.getTheBankCreator().createBank(BankName1, adminTestLimits);
		bankTestLimits.createAccount("Euro");
		bankTestLimits.createAccount("Euro");

		PersistentAccount acc1 = bankTestLimits.getAccounts().get(FirstAccountNumber);

		PersistentLimitAccount limit1 = LimitAccount.createLimitAccount();
		limit1.setMinLimit(Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(0, 1)), Euro.getTheEuro())));
		acc1.setLimit(limit1);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(SecondAccountNumber);
		newTrans.setReceiverBankNumber(bankTestLimits.getBankNumber());
		System.err.println(bankTestLimits.getBankNumber());
		try {
			newTrans.execute();
		} catch (DebitException e) {
			assertTrue(true);
			return;
		}
		fail("Es hätte ein Fehler auftreten sollen, weil Limit überschritten!!!");
	}
	@Test
	public void testLimitsMax() throws PersistenceException, ExecuteException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		System.out.println("last bank" + BankCreator.getTheBankCreator().getLastBankNumber());
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);

		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
		PersistentLimitAccount limit1 = LimitAccount.createLimitAccount();
		limit1.setMaxLimit(Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro())));
		acc2.setLimit(limit1);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(100, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(SecondAccountNumber);
		newTrans.setReceiverBankNumber(bank.getBankNumber());
		try {
			newTrans.execute();
		} catch (DebitException e) {
			assertTrue(true);
			return;
		}	
		
		fail("Es hätte ein Fehler auftreten sollen, weil Limit überschritten!!!");

	}
	@Test
	public void testBankExternFixFee() throws PersistenceException, ExecuteException {
		PersistentAdministrator adminTestLimits = Administrator.createAdministrator();

		PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1, adminTestLimits);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, adminTestLimits);
		bank1.getBankFees().setFee(FixTransactionFee.createFixTransactionFee(Money.createMoney(Amount.createAmount(new Fraction(1, 1)), Euro.getTheEuro())));
		long bankNumber2 = bank2.getBankNumber();
		bank1.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(FirstAccountNumber);
		newTrans.setReceiverBankNumber(bankNumber2);
		newTrans.execute();
		assertEquals(new Fraction(-11, 1), acc1.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(10, 1), acc2.getMoney().getAmount().getBalance());
	}
	@Test
	public void testBankExternProcentualFee() throws PersistenceException, ExecuteException {
		PersistentAdministrator adminTestLimits = Administrator.createAdministrator();

		PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1, adminTestLimits);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, adminTestLimits);
		bank1.getBankFees().setFee(ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 2))));
		bank1.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(FirstAccountNumber);
		newTrans.setReceiverBankNumber(bank2.getBankNumber());
		newTrans.execute();
		assertEquals(new Fraction(-15, 1), acc1.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(10, 1), acc2.getMoney().getAmount().getBalance());
	}
	@Test
	public void testBankExternMixedFee() throws PersistenceException, ExecuteException {
		PersistentAdministrator adminTestLimits = Administrator.createAdministrator();

		PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1, adminTestLimits);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, adminTestLimits);
		PersistentProcentualFee procentualFee = ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 2)));
		PersistentFixTransactionFee fixFee = FixTransactionFee.createFixTransactionFee(Money.createMoney(Amount.createAmount(new Fraction(3, 1)),
				Euro.getTheEuro()));
		bank1.getBankFees().setFee(MixedFee.createMixedFee(fixFee, procentualFee, Money.createMoney(Amount.createAmount(new Fraction(5, 1)), Euro.getTheEuro())));
		long bankNumber2 = bank2.getBankNumber();
		bank1.createAccount("Euro");
		bank2.createAccount("Euro");
		final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;

		PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(11, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(FirstAccountNumber);
		newTrans.setReceiverBankNumber(bankNumber2);
		newTrans.execute();
		assertEquals(new Fraction(-17, 1), acc1.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(11, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(6, 1), bank1.getOwnAccount().getMoney().getAmount().getBalance());
		assertEquals(Fraction.Null, bank2.getOwnAccount().getMoney().getAmount().getBalance());
	}
	
	@Test
	public void testBankExternProcentualFeeLimitViolation() throws PersistenceException, ExecuteException {
		PersistentAdministrator adminTestLimits = Administrator.createAdministrator();

		PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1, adminTestLimits);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, adminTestLimits);
		bank1.getBankFees().setFee(ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 2))));
		bank1.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);

		PersistentLimitAccount limit = LimitAccount.createLimitAccount();
		limit.setMinLimit(Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(-13, 1)), Euro.getTheEuro())));
		acc1.setLimit(limit);
		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(FirstAccountNumber);
		newTrans.setReceiverBankNumber(bank2.getBankNumber());
		try {
			newTrans.execute();
		} catch (DebitException e) {
			assertTrue(true);
			return;
		}
		fail("Es hätte ein Fehler auftreten sollen, weil Limit überschritten!!!");
	}
	@Test
	public void testBankinternNoCharge() throws PersistenceException, ExecuteException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(100, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(SecondAccountNumber);
		newTrans.setReceiverBankNumber(bank.getBankNumber());
		newTrans.execute();

		assertEquals(new Fraction(100, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(-100, 1), acc1.getMoney().getAmount().getBalance());
		assertEquals(Fraction.Null, bank.getOwnAccount().getMoney().getAmount().getBalance());

	}
	@Test
	public void testBankinternZeroMoney() throws PersistenceException, ExecuteException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(0, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(SecondAccountNumber);
		newTrans.setReceiverBankNumber(bank.getBankNumber());
		newTrans.execute();

		assertEquals(new Fraction(0, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(0, 1), acc1.getMoney().getAmount().getBalance());
		assertEquals(Fraction.Null, bank.getOwnAccount().getMoney().getAmount().getBalance());

	}
	@Test
	public void testBankExternNoCharge() throws PersistenceException, ExecuteException {
		PersistentAdministrator adminTestLimits = Administrator.createAdministrator();

		PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1, adminTestLimits);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, adminTestLimits);
		bank1.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(FirstAccountNumber);
		newTrans.setReceiverBankNumber(bank2.getBankNumber());
		newTrans.execute();

		assertEquals(new Fraction(-10, 1), acc1.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(10, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(Fraction.Null, bank1.getOwnAccount().getMoney().getAmount().getBalance());
		assertEquals(Fraction.Null, bank2.getOwnAccount().getMoney().getAmount().getBalance());
	}
	@Test
	public void testBankExternFixFee2() throws PersistenceException, ExecuteException {
		PersistentAdministrator adminTestLimits = Administrator.createAdministrator();

		PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1, adminTestLimits);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, adminTestLimits);
		bank1.getBankFees().setFee(FixTransactionFee.createFixTransactionFee(Money.createMoney(Amount.createAmount(new Fraction(5, 1)), Euro.getTheEuro())));
		bank1.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(100, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(FirstAccountNumber);
		newTrans.setReceiverBankNumber(bank2.getBankNumber());
		newTrans.execute();

		assertEquals(new Fraction(-105, 1), acc1.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(100, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(5, 1), bank1.getOwnAccount().getMoney().getAmount().getBalance());
		assertEquals(Fraction.Null, bank2.getOwnAccount().getMoney().getAmount().getBalance());

	}
	@Test
	public void testBankinternFixFee() throws PersistenceException, ExecuteException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.getBankFees().setFee(FixTransactionFee.createFixTransactionFee(Money.createMoney(Amount.createAmount(new Fraction(5, 1)), Euro.getTheEuro())));
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(100, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(SecondAccountNumber);
		newTrans.setReceiverBankNumber(bank.getBankNumber());
		newTrans.execute();

		assertEquals(new Fraction(100, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(-105, 1), acc1.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(5, 1), bank.getOwnAccount().getMoney().getAmount().getBalance());
	}
	@Test
	public void testBankExternProcentualFee2() throws PersistenceException, ExecuteException {
		PersistentAdministrator adminTestLimits = Administrator.createAdministrator();

		PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1, adminTestLimits);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, adminTestLimits);
		bank1.getBankFees().setFee(ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 20))));
		bank1.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(200, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(FirstAccountNumber);
		newTrans.setReceiverBankNumber(bank2.getBankNumber());
		newTrans.execute();
		assertEquals(new Fraction(-210, 1), acc1.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(200, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(10, 1), bank1.getOwnAccount().getMoney().getAmount().getBalance());
		assertEquals(Fraction.Null, bank2.getOwnAccount().getMoney().getAmount().getBalance());
	}
	@Test
	public void testBankinternProcentualFee() throws PersistenceException, ExecuteException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.getBankFees().setFee(ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 20))));
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(200, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(SecondAccountNumber);
		newTrans.setReceiverBankNumber(bank.getBankNumber());
		newTrans.execute();

		assertEquals(new Fraction(200, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(-210, 1), acc1.getMoney().getAmount().getBalance());
	}
	@Test
	public void testBankExternMixedFee2() throws PersistenceException, ExecuteException {
		PersistentAdministrator a = Administrator.createAdministrator();

		PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1, a);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, a);
		PersistentProcentualFee procentualFee = ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 20)));
		PersistentFixTransactionFee fixFee = FixTransactionFee.createFixTransactionFee(Money.createMoney(Amount.createAmount(new Fraction(5, 1)),
				Euro.getTheEuro()));
		bank1.getBankFees().setFee(MixedFee.createMixedFee(fixFee, procentualFee, Money.createMoney(Amount.createAmount(new Fraction(50, 1)), Euro.getTheEuro())));
		bank1.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(150, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(FirstAccountNumber);
		newTrans.setReceiverBankNumber(bank2.getBankNumber());
		newTrans.execute();

		assertEquals(new Fraction(-160, 1), acc1.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(150, 1), acc2.getMoney().getAmount().getBalance());
	}
	@Test
	public void testBankInternMixFee() throws PersistenceException, ExecuteException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		PersistentProcentualFee procentualFee = ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 20)));
		PersistentFixTransactionFee fixFee = FixTransactionFee.createFixTransactionFee(Money.createMoney(Amount.createAmount(new Fraction(5, 1)),
				Euro.getTheEuro()));
		bank.getBankFees().setFee(MixedFee.createMixedFee(fixFee, procentualFee, Money.createMoney(Amount.createAmount(new Fraction(50, 1)), Euro.getTheEuro())));
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(150, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(SecondAccountNumber);
		newTrans.setReceiverBankNumber(bank.getBankNumber());
		newTrans.execute();

		assertMoneyEquals(Money.createMoney(Amount.createAmount(Fraction.parse("150")), Euro.getTheEuro()), acc2.getMoney());
		assertMoneyEquals(Money.createMoney(Amount.createAmount(Fraction.parse("-160")), Euro.getTheEuro()), acc1.getMoney());
	}
	@Test
	public void testBankExternFixFeeLimitViolation() throws PersistenceException, ExecuteException {
		PersistentAdministrator adminTestLimits = Administrator.createAdministrator();

		PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1, adminTestLimits);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, adminTestLimits);
		bank1.getBankFees().setFee(FixTransactionFee.createFixTransactionFee(Money.createMoney(Amount.createAmount(Fraction.parse("5")), Euro.getTheEuro())));
		bank1.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);

		PersistentLimitAccount limit = LimitAccount.createLimitAccount();
		limit.setMinLimit(Limit.createLimit(Money.createMoney(Amount.createAmount(Fraction.parse("-50")), Euro.getTheEuro())));
		acc1.setLimit(limit);
		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(Fraction.parse("50")), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(FirstAccountNumber);
		newTrans.setReceiverBankNumber(bank2.getBankNumber());
		try {
			newTrans.execute();
		} catch (DebitException e) {
			assertTrue(true);
			return;
		}
		fail("Es hätte ein Fehler auftreten sollen, weil Limit überschritten!!!");
	}
	@Test
	public void testBankInternLimitViolation() throws PersistenceException, ExecuteException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);

		PersistentLimitAccount limit = LimitAccount.createLimitAccount();
		limit.setMinLimit(Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(-50, 1)), Euro.getTheEuro())));
		acc1.setLimit(limit);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(51, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(SecondAccountNumber);
		newTrans.setReceiverBankNumber(bank.getBankNumber());
		try {
			newTrans.execute();
		} catch (DebitException e) {
			assertTrue(true);
			return;
		}
		fail("Es hätte ein Fehler auftreten sollen, weil Limit überschritten!!!");
	}
	@Test
	public void testBankExternProcentualFeeLimitViolation2() throws PersistenceException, ExecuteException {
		PersistentAdministrator adminTestLimits = Administrator.createAdministrator();

		PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1, adminTestLimits);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, adminTestLimits);
		bank1.getBankFees().setFee(ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 20))));
		bank1.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);

		PersistentLimitAccount limit = LimitAccount.createLimitAccount();
		limit.setMaxLimit(Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(99, 1)), Euro.getTheEuro())));
		acc2.setLimit(limit);
		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(100, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(FirstAccountNumber);
		newTrans.setReceiverBankNumber(bank2.getBankNumber());
		try {
			newTrans.execute();
		} catch (DebitException e) {
			assertTrue(true);
			return;
		}
		fail("Es hätte ein Fehler auftreten sollen, weil Limit überschritten!!!");
	}
	@Test
	public void testBankExternCurrencyTransfer() throws PersistenceException, ExecuteException {
		PersistentAdministrator a = Administrator.createAdministrator();

		a.changeCurrencyRateGUI("Euro", Fraction.parse("2"));
		a.changeCurrencyRateGUI("Dollar", Fraction.parse("1"));
		a.changeCurrencyRateGUI("Pfund", Fraction.parse("3"));

		PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1, a);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, a);
		bank1.createAccount("Euro");
		bank2.createAccount("Pfund");

		PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);

		PersistentTransfer newTrans = acc1.createTransfer();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(100, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(FirstAccountNumber);
		newTrans.setReceiverBankNumber(bank2.getBankNumber());
		newTrans.execute();

		PersistentMoney m1 = Money.createMoney(Amount.createAmount(Fraction.parse("-100")), Euro.getTheEuro());
		PersistentMoney m2 = Money.createMoney(Amount.createAmount(Fraction.parse("150")), Pfund.getThePfund());
		assertMoneyEquals(m1, acc1.getMoney());
		assertMoneyEquals(m2, acc2.getMoney());
	}

}
