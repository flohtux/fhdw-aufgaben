package test;

import static org.junit.Assert.assertEquals;
import model.Administrator;
import model.Amount;
import model.BankCreator;
import model.DoubleRuleDefinitionException;
import model.Euro;
import model.ExecuteException;
import model.IncomingAccountRule;
import model.Money;
import model.MoneyRule;
import model.NoRuleDefinitionException;
import model.PasswordException;
import model.SubjectRule;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAdministrator;
import persistence.PersistentBank;
import persistence.PersistentIncomingAccountRule;
import persistence.PersistentMoneyRule;
import persistence.PersistentSubjectRule;
import persistence.PersistentTransfer;
import persistence.PersistentTrigger;

import common.Fraction;

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
//			 ConnectionHandler.getTheConnectionHandler().connect("localhost:1521:xe",
//			 "bank", "bank", "pg".toCharArray(), false);
			TestSupport.prepareSingletons();
			persistence.Cache.getTheCache().reset$For$Test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMatchedSubjectRule() throws PersistenceException, ExecuteException, InterruptedException, PasswordException, NoRuleDefinitionException, DoubleRuleDefinitionException {
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
		tr.addRule(rule);
		tr.enable();
		PersistentTransfer initTransfer = acc1.createTransfer();
		initTransfer.setMoney(Money.createMoney(Amount.createAmount(new Fraction(50, 1)), Euro.getTheEuro()));
		initTransfer.setReceiverAccountNumber(SecondAccountNumber);
		initTransfer.setReceiverBankNumber(bank.getBankNumber());
		initTransfer.setSubject("Das ist MeinBetreff!");
		initTransfer.execute(acc1, acc1.getAccountService());
		
		assertEquals(Fraction.parse("-45"), acc1.getMoney().getAmount().getBalance());
		assertEquals(0, acc1.getAccountService().getErrors().getLength());
		assertEquals(0, acc2.getAccountService().getErrors().getLength());
	}
	
	@Test
	public void testMatchedIncomingAccountRule() throws PersistenceException, ExecuteException, InterruptedException, PasswordException, NoRuleDefinitionException, DoubleRuleDefinitionException {
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
		
		PersistentIncomingAccountRule rule = IncomingAccountRule.createIncomingAccountRule();
		rule.setAccountNumber(FirstAccountNumber);
		rule.setBankNumber(bank.getBankNumber());
		tr.addRule(rule);
		tr.enable();
		PersistentTransfer initTransfer = acc1.createTransfer();
		initTransfer.setMoney(Money.createMoney(Amount.createAmount(new Fraction(50, 1)), Euro.getTheEuro()));
		initTransfer.setReceiverAccountNumber(SecondAccountNumber);
		initTransfer.setReceiverBankNumber(bank.getBankNumber());
		initTransfer.setSubject("Das ist MeinBetreff!");
		initTransfer.execute(acc1);
		
		assertEquals(Fraction.parse("-45"), acc1.getMoney().getAmount().getBalance());
		assertEquals(0, acc1.getAccountService().getErrors().getLength());
		assertEquals(0, acc2.getAccountService().getErrors().getLength());
	}

	@Test
	public void testMatchedMoneyRule() throws PersistenceException, ExecuteException, InterruptedException, PasswordException, NoRuleDefinitionException, DoubleRuleDefinitionException {
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
		
		PersistentMoneyRule rule = MoneyRule.createMoneyRule(acc2.getMoney().getCurrency());
		rule.setMinLimit(Amount.createAmount(new Fraction(7, 1)));
		rule.setMaxLimit(Amount.createAmount(new Fraction(7, 1)));
		tr.addRule(rule);
		tr.enable();
		PersistentTransfer initTransfer = acc1.createTransfer();
		initTransfer.setMoney(Money.createMoney(Amount.createAmount(new Fraction(7, 1)), Euro.getTheEuro()));
		initTransfer.setReceiverAccountNumber(SecondAccountNumber);
		initTransfer.setReceiverBankNumber(bank.getBankNumber());
		initTransfer.setSubject("Das ist MeinBetreff!");
		initTransfer.execute(acc1);
		
		assertEquals(Fraction.parse("-2"), acc1.getMoney().getAmount().getBalance());
		assertEquals(0, acc1.getAccountService().getErrors().getLength());
		assertEquals(0, acc2.getAccountService().getErrors().getLength());
	}
	
	@Test
	public void testMatchedSubjectRuleCyclic() throws PersistenceException, ExecuteException, InterruptedException, PasswordException, NoRuleDefinitionException, DoubleRuleDefinitionException {
		PersistentAdministrator admin = Administrator.createAdministrator();

		PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		bank.createAccount("Euro");
		bank.createAccount("Euro");
		
		PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
		acc1.getAccountService().changePassword("test", "test");
		
		PersistentTransfer action = acc2.createTransfer();
		PersistentTrigger tr = acc2.createTrigger("Überweis Janik 5 Euro",action);
		
		PersistentTransfer actionBack = acc1.createTransfer();
		PersistentTrigger trAcc1 = acc1.createTrigger("Überweisung 10 Euro zurück", actionBack);
		
	
		action.setMoney(Money.createMoney(Amount.createAmount(new Fraction(5, 1)), Euro.getTheEuro()));
		action.setReceiverAccountNumber(SecondAccountNumber);
		action.setReceiverBankNumber(bank.getBankNumber());
		action.setSubject("Das ist MeinBetreff zurück!!");
		
		PersistentSubjectRule rule = SubjectRule.createSubjectRule();
		rule.setSubject("MeinBetreff");
		tr.addRule(rule);
		tr.enable();
		PersistentSubjectRule rule2 = SubjectRule.createSubjectRule();
		rule2.setSubject("MeinBetreff");
		trAcc1.addRule(rule2);
		trAcc1.enable();
		PersistentTransfer initTransfer = acc1.createTransfer();
		initTransfer.setMoney(Money.createMoney(Amount.createAmount(new Fraction(50, 1)), Euro.getTheEuro()));
		initTransfer.setReceiverAccountNumber(SecondAccountNumber);
		initTransfer.setReceiverBankNumber(bank.getBankNumber());
		initTransfer.setSubject("Das ist MeinBetreff!");
		initTransfer.execute(acc1);
		
		assertEquals(Fraction.parse("-50"), acc1.getMoney().getAmount().getBalance());
		assertEquals(1, acc1.getAccountService().getErrors().getLength());
		assertEquals(0, acc2.getAccountService().getErrors().getLength());
	}
}
