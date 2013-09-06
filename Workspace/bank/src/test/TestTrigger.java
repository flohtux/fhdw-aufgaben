package test;

import static org.junit.Assert.*;
import model.Administrator;
import model.Amount;
import model.BankCreator;
import model.Dollar;
import model.Euro;
import model.ExecuteException;
import model.Money;
import model.PasswordException;
import model.SubjectRule;
import model.Trigger;

import org.junit.Before;
import org.junit.Test;

import common.Fraction;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAdministrator;
import persistence.PersistentBank;
import persistence.PersistentRule;
import persistence.PersistentSubjectRule;
import persistence.PersistentTransfer;
import persistence.PersistentTrigger;
import persistence.Predcate;

public class TestTrigger {

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
	
	@Test
	public void test() throws PersistenceException, ExecuteException, InterruptedException, PasswordException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");

		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
		
		acc1.getAccountService().changePassword("test", "test");
		PersistentTransfer action = acc2.createTransfer();
		PersistentTrigger tr = acc2.createTrigger("Überweis Janik 5 Euro",action);
		
	
		action.setMoney(Money.createMoney(Amount.createAmount(new Fraction(5, 1)), Euro.getTheEuro()));
		action.setReceiverAccountNumber(FirstAccountNumber);
		action.setReceiverBankNumber(bank.getBankNumber());
		
		PersistentSubjectRule rule = SubjectRule.createSubjectRule();
		rule.setSubject("MeinBetreff");
		tr.getRules().add(rule);
		
		tr.setAction(action);
		
		PersistentTransfer initTransfer = acc1.createTransfer();
		initTransfer.setMoney(Money.createMoney(Amount.createAmount(new Fraction(50, 1)), Euro.getTheEuro()));
		initTransfer.setReceiverAccountNumber(SecondAccountNumber);
		initTransfer.setReceiverBankNumber(bank.getBankNumber());
		initTransfer.setSubject("Das ist MeinBetreff!");
		initTransfer.execute();
		
		synchronized (this) {
			this.wait(1000);			
		}

		
		assertEquals(Fraction.parse("-45"), acc1.getMoney().getAmount().getBalance());
		
	}

}
