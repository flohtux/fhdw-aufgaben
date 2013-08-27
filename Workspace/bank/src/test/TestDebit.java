package test;

import static org.junit.Assert.*;
import model.Administrator;
import model.Amount;
import model.BankCreator;
import model.DebitException;
import model.DebitNotGrantedException;
import model.Dollar;
import model.Euro;
import model.FixTransactionFee;
import model.InvalidAccountNumberException;
import model.InvalidBankNumberException;
import model.Limit;
import model.LimitAccount;
import model.DebitException;
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
	
	@Test(expected=DebitNotGrantedException.class)
	public void testDebit1() throws Exception {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);

		PersistentDebit newDebit = acc1.createDebit();
		newDebit.setMoney(Money.createMoney(Amount.createAmount(new Fraction(-10, 1)), Euro.getTheEuro()));
		newDebit.setReceiverAccountNumber(SecondAccountNumber);
		newDebit.setReceiverBankNumber(bank.getBankNumber());
		newDebit.execute();

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
		assertTrue(newDebit.getState().equals(SuccessfulState.getTheSuccessfulState()));
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
		assertTrue(newDebit.getState().equals(SuccessfulState.getTheSuccessfulState()));
//		System.out.println(acc2.getMoney()+"acc2");
//		System.out.println("acc1"+acc1.getMoney());
		assertEquals(new Fraction(-10, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(10, 1), acc1.getMoney().getAmount().getBalance());
	}
}
