package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import model.Administrator;
import model.Amount;
import model.BankCreator;
import model.Euro;
import model.ExecuteException;
import model.InvalidBankNumberException;
import model.Money;

import org.junit.Before;
import org.junit.Test;

import persistence.DebitTransferSearchList;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAdministrator;
import persistence.PersistentBank;
import persistence.PersistentTransaction;
import persistence.PersistentTransfer;

import common.Fraction;

public class TestTransaction{

	private final String BankName1 = "Bank1";
	private final String BankName2 = "Bank2";
	private final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
	private final long SecondAccountNumber = FirstAccountNumber + 1;
	
	@Before
	public void setUpDatabase() {
		try {
			TestSupport.prepareDatabase(); // TODO PREREQUISITES: Test:
//			 substitute by following statement
//			 for database-less test:
//			 ConnectionHandler.getTheConnectionHandler().connect("localhost:1521:xe",
//			 "bank", "bank", "pg".toCharArray(), false);
			TestSupport.prepareSingletons();
			persistence.Cache.getTheCache().reset$For$Test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void test() throws ExecuteException, PersistenceException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);

		PersistentTransfer newTrans1 = acc1.createTransfer();
		newTrans1.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newTrans1.setReceiverAccountNumber(SecondAccountNumber);
		newTrans1.setReceiverBankNumber(bank.getBankNumber());
		PersistentTransfer newTrans2 = acc1.createTransfer();
		newTrans2.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newTrans2.setReceiverAccountNumber(SecondAccountNumber);
		newTrans2.setReceiverBankNumber(bank.getBankNumber());
		
		PersistentTransaction newTrans = acc1.createTransaction();
		DebitTransferSearchList trans = new DebitTransferSearchList();
		trans.add(newTrans1);
		trans.add(newTrans2);
		newTrans.addToTransaction(trans);
		newTrans.execute(acc1);

		assertEquals(new Fraction(20, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(-20, 1), acc1.getMoney().getAmount().getBalance());
	}
	
	@Test
	public void test2() throws ExecuteException, PersistenceException {
		PersistentAdministrator admin = Administrator.createAdministrator();
		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
		
		
		PersistentTransfer newTrans1 = acc1.createTransfer();
		newTrans1.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newTrans1.setReceiverAccountNumber(SecondAccountNumber);
		newTrans1.setReceiverBankNumber(bank.getBankNumber());
		PersistentTransfer newTrans2 = acc1.createTransfer();
		newTrans2.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro()));
		newTrans2.setReceiverAccountNumber(SecondAccountNumber);
		newTrans2.setReceiverBankNumber(42);
		 
		PersistentTransaction newTrans = acc1.createTransaction();
		DebitTransferSearchList transList = new DebitTransferSearchList();
		transList.add(newTrans1);
		transList.add(newTrans2);
		newTrans.addToTransaction(transList);
		try {
		newTrans.execute(acc1);
		}catch(InvalidBankNumberException e) {
			assertTrue(true);
		}
		
		assertEquals(new Fraction(0, 1), acc2.getMoney().getAmount().getBalance());
		assertEquals(new Fraction(0, 1), acc1.getMoney().getAmount().getBalance());
		System.out.println(acc1.getAccountService().getErrors());
	}

}
