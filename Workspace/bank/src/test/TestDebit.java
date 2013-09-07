package test;

import static org.junit.Assert.*;
import model.Administrator;
import model.Amount;
import model.BankCreator;
import model.DebitException;
import model.DebitNotGrantedException;
import model.Dollar;
import model.Euro;
import model.ExecuteException;
import model.FixTransactionFee;
import model.GrantAlreadyGivenException;
import model.InvalidAccountNumberException;
import model.InvalidBankNumberException;
import model.Limit;
import model.LimitAccount;
import model.DebitException;
import model.LimitViolatedException;
import model.MixedFee;
import model.Money;
import model.NoLimit;
import model.NoPermissionToExecuteDebitTransferException;
import model.NotExecutedState;
import model.NotSuccessfulState;
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
import persistence.PersistentDebit;
import persistence.PersistentFixTransactionFee;
import persistence.PersistentLimitAccount;
import persistence.PersistentMoney;
import persistence.PersistentProcentualFee;
import persistence.PersistentSuccessfulState;
import persistence.PersistentTransfer;
import common.Fraction;

public class TestDebit {

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
	public void testBankintern() throws PersistenceException, ExecuteException, GrantAlreadyGivenException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
		
		acc2.createDebitGrant(acc1, Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(25, 1)), acc2.getMoney().getCurrency())));
		
		PersistentDebit newTrans = acc1.createDebit();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(SecondAccountNumber);
		newTrans.setReceiverBankNumber(bank.getBankNumber());
		newTrans.execute();

		assertEquals(new Fraction(-10, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(10, 1), acc1.getMoney().getAmount().getBalance());
		assertTrue(newTrans.getState() instanceof PersistentSuccessfulState);
	}
	
	@Test(expected=DebitNotGrantedException.class)
	public void testBankinternGrantException() throws Exception {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);

		PersistentDebit newDebit = acc1.createDebit();
		newDebit.setMoney(Money.createMoney(Amount.createAmount(new Fraction(-10, 1)), Euro.getTheEuro()));
		newDebit.setReceiverAccountNumber(SecondAccountNumber);
		newDebit.setReceiverBankNumber(bank.getBankNumber());
		newDebit.execute();

	}
	
	@Test
	public void testBankinternOneLower() throws Exception {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
		acc2.createDebitGrant(acc1, Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(25, 1)), acc2.getMoney().getCurrency())));
		
		PersistentDebit newDebit = acc1.createDebit();
		newDebit.setMoney(Money.createMoney(Amount.createAmount(new Fraction(24, 1)), Euro.getTheEuro()));
		newDebit.setReceiverAccountNumber(SecondAccountNumber);
		newDebit.setReceiverBankNumber(bank.getBankNumber());
		newDebit.execute();

		assertEquals(new Fraction(-24, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(24, 1), acc1.getMoney().getAmount().getBalance());
		assertTrue(newDebit.getState() instanceof PersistentSuccessfulState);
	}
	
	@Test
	public void testBankinternLimitEquals() throws Exception {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
		acc2.createDebitGrant(acc1, Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(25, 1)), acc2.getMoney().getCurrency())));
		
		PersistentDebit newDebit = acc1.createDebit();
		newDebit.setMoney(Money.createMoney(Amount.createAmount(new Fraction(25, 1)), Euro.getTheEuro()));
		newDebit.setReceiverAccountNumber(SecondAccountNumber);
		newDebit.setReceiverBankNumber(bank.getBankNumber());
		newDebit.execute();

		assertEquals(new Fraction(-25, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(25, 1), acc1.getMoney().getAmount().getBalance());
		assertTrue(newDebit.getState() instanceof PersistentSuccessfulState);
	}
	
	@Test(expected=LimitViolatedException.class)
	public void testBankinternGrantExceptionOneMore() throws Exception {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
		acc2.createDebitGrant(acc1, Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(25, 1)), acc2.getMoney().getCurrency())));
		
		PersistentDebit newDebit = acc1.createDebit();
		newDebit.setMoney(Money.createMoney(Amount.createAmount(new Fraction(26, 1)), Euro.getTheEuro()));
		newDebit.setReceiverAccountNumber(SecondAccountNumber);
		newDebit.setReceiverBankNumber(bank.getBankNumber());
		newDebit.execute();

	}
	
	@Test
	public void testBankinternOtherCurrencies() throws PersistenceException, ExecuteException, GrantAlreadyGivenException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);

		acc2.createDebitGrant(acc1, Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(25, 1)), acc2.getMoney().getCurrency())));
		
		PersistentDebit newTrans = acc1.createDebit();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Dollar.getTheDollar()));
		newTrans.setReceiverAccountNumber(SecondAccountNumber);
		newTrans.setReceiverBankNumber(bank.getBankNumber());
		newTrans.execute();

		assertEquals(new Fraction(-10, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(10, 1), acc1.getMoney().getAmount().getBalance());
		assertTrue(newTrans.getState() instanceof PersistentSuccessfulState);

	}
	
	@Test
	public void testBankextern() throws PersistenceException, ExecuteException, GrantAlreadyGivenException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, admin);
		bank.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
		
		acc2.createDebitGrant(acc1, Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(25, 1)), acc2.getMoney().getCurrency())));
		
		PersistentDebit newTrans = acc1.createDebit();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newTrans.setReceiverAccountNumber(FirstAccountNumber);
		newTrans.setReceiverBankNumber(bank2.getBankNumber());
		newTrans.execute();

		assertEquals(new Fraction(-10, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(10, 1), acc1.getMoney().getAmount().getBalance());
		assertTrue(newTrans.getState() instanceof PersistentSuccessfulState);
	}
	
	@Test(expected=DebitNotGrantedException.class)
	public void testBankexternGrantException() throws Exception {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, admin);
		bank.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);

		PersistentDebit newDebit = acc1.createDebit();
		newDebit.setMoney(Money.createMoney(Amount.createAmount(new Fraction(-10, 1)), Euro.getTheEuro()));
		newDebit.setReceiverAccountNumber(FirstAccountNumber);
		newDebit.setReceiverBankNumber(bank2.getBankNumber());
		newDebit.execute();

	}
	
	@Test
	public void testBankexternOneLower() throws Exception {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, admin);
		bank.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
		acc2.createDebitGrant(acc1, Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(25, 1)), acc2.getMoney().getCurrency())));
		
		PersistentDebit newDebit = acc1.createDebit();
		newDebit.setMoney(Money.createMoney(Amount.createAmount(new Fraction(24, 1)), Euro.getTheEuro()));
		newDebit.setReceiverAccountNumber(FirstAccountNumber);
		newDebit.setReceiverBankNumber(bank2.getBankNumber());
		newDebit.execute();

		assertEquals(new Fraction(-24, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(24, 1), acc1.getMoney().getAmount().getBalance());
		assertTrue(newDebit.getState() instanceof PersistentSuccessfulState);
	}
	
	@Test
	public void testBankexternGrantExceptionLimitEquals() throws Exception {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, admin);
		bank.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
		acc2.createDebitGrant(acc1, Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(25, 1)), acc2.getMoney().getCurrency())));
		
		PersistentDebit newDebit = acc1.createDebit();
		newDebit.setMoney(Money.createMoney(Amount.createAmount(new Fraction(25, 1)), Euro.getTheEuro()));
		newDebit.setReceiverAccountNumber(FirstAccountNumber);
		newDebit.setReceiverBankNumber(bank2.getBankNumber());
		newDebit.execute();

		assertEquals(new Fraction(-25, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(25, 1), acc1.getMoney().getAmount().getBalance());
		assertTrue(newDebit.getState() instanceof PersistentSuccessfulState);
	}
	
	@Test(expected=LimitViolatedException.class)
	public void testBankexternGrantExceptionOneMore() throws Exception {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, admin);
		bank.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
		acc2.createDebitGrant(acc1, Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(25, 1)), acc2.getMoney().getCurrency())));
		
		PersistentDebit newDebit = acc1.createDebit();
		newDebit.setMoney(Money.createMoney(Amount.createAmount(new Fraction(26, 1)), Euro.getTheEuro()));
		newDebit.setReceiverAccountNumber(FirstAccountNumber);
		newDebit.setReceiverBankNumber(bank2.getBankNumber());
		newDebit.execute();

	}
	
	@Test
	public void testBankexternOtherCurrencies() throws PersistenceException, ExecuteException, GrantAlreadyGivenException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, admin);
		bank.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);

		acc2.createDebitGrant(acc1, Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(25, 1)), acc2.getMoney().getCurrency())));
		
		PersistentDebit newTrans = acc1.createDebit();
		newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Dollar.getTheDollar()));
		newTrans.setReceiverAccountNumber(FirstAccountNumber);
		newTrans.setReceiverBankNumber(bank2.getBankNumber());
		newTrans.execute();

		assertEquals(new Fraction(-10, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(10, 1), acc1.getMoney().getAmount().getBalance());
		assertTrue(newTrans.getState() instanceof PersistentSuccessfulState);

	}
	
	@Test
	public void testDebit2() throws Exception {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);

		acc2.createDebitGrant(acc1, NoLimit.getTheNoLimit());
		System.out.println(acc1.getReceivedDebitGrant().getDebitGrants());
		System.out.println(acc1.getGrantedDebitGrant().getDebitGrants());
		System.out.println(acc2.getGrantedDebitGrant().getDebitGrants());
		System.out.println(acc2.getReceivedDebitGrant().getDebitGrants().getLength());
		PersistentDebit newDebit = acc1.createDebit();
		newDebit.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newDebit.setReceiverAccountNumber(SecondAccountNumber);
		newDebit.setReceiverBankNumber(bank.getBankNumber());
		newDebit.execute();
//		System.out.println("stata"+newDebit.getState());
		assertTrue(newDebit.getState() instanceof PersistentSuccessfulState);
//		System.out.println(acc2.getMoney()+"acc2");
//		System.out.println("acc1"+acc1.getMoney());
		assertEquals(new Fraction(-10, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(10, 1), acc1.getMoney().getAmount().getBalance());
	}
	
	@Test
	public void testDebit3() throws Exception {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2, admin);
		bank.createAccount("Euro");
		bank2.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);

		acc2.createDebitGrant(acc1, NoLimit.getTheNoLimit());
		PersistentDebit newDebit = acc1.createDebit();
		newDebit.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newDebit.setReceiverAccountNumber(FirstAccountNumber);
		newDebit.setReceiverBankNumber(bank2.getBankNumber());
		newDebit.execute();
		assertTrue(newDebit.getState() instanceof PersistentSuccessfulState);
//		System.out.println(acc2.getMoney()+"acc2");
//		System.out.println("acc1"+acc1.getMoney());
		assertEquals(new Fraction(-10, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(10, 1), acc1.getMoney().getAmount().getBalance());
	}
}
