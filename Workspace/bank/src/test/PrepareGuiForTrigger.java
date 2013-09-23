package test;

import static org.junit.Assert.*;
import model.Administrator;
import model.Amount;
import model.BankCreator;
import model.DoubleRuleDefinitionException;
import model.Euro;
import model.Money;
import model.NoRuleDefinitionException;
import model.SubjectRule;

import org.junit.Before;
import org.junit.Test;

import common.Fraction;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAdministrator;
import persistence.PersistentBank;
import persistence.PersistentTransfer;
import persistence.PersistentTrigger;

public class PrepareGuiForTrigger {
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
	
	/**
	 * Erzeugt einen Standardfall für die Oberfläche:
	 * also 2 accounts 1@1 und 2@1 mit jeweils einem zyklischen trigger.
	 * resettet natürlich vorher
	 */
	@Test
	public void test() throws PersistenceException, DoubleRuleDefinitionException, NoRuleDefinitionException {
		PersistentAdministrator admin = Administrator.createAdministrator();
		PersistentBank b = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		b.createAccount("Euro");
		b.createAccount("Euro");
		
		PersistentAccount acc1 = b.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = b.getAccounts().get(SecondAccountNumber);
		
		PersistentTransfer action = acc2.createTransfer();
		action.setSubject("Folge 2->1");
		action.setMoney(Money.createMoney(Amount.createAmount(Fraction.parseDec("12")), Euro.getTheEuro()));
		action.setReceiverAccountNumber(acc1.getAccountNumber());
		action.setReceiverBankNumber(acc1.getBank().getBankNumber());
		PersistentTrigger tr = acc2.createTrigger("T2",action);
		tr.addRule(SubjectRule.createSubjectRule());
		tr.enable();
		
		PersistentTransfer action2 = acc1.createTransfer();
		action2.setSubject("Folge 1->2");
		action2.setReceiverAccountNumber(acc2.getAccountNumber());
		action2.setReceiverBankNumber(acc2.getBank().getBankNumber());
		action2.setMoney(Money.createMoney(Amount.createAmount(Fraction.parseDec("13")), Euro.getTheEuro()));
		PersistentTrigger tr2 = acc1.createTrigger("T1",action2);
		tr2.addRule(SubjectRule.createSubjectRule());
		tr2.enable();
		
		
		
		
		
	}
	
	@Test
	public void test2() throws PersistenceException, DoubleRuleDefinitionException, NoRuleDefinitionException {
		PersistentAdministrator admin = Administrator.createAdministrator();
		PersistentBank b = BankCreator.getTheBankCreator().createBank(BankName1, admin);
		b.createAccount("Euro");
		b.createAccount("Euro");
		
		PersistentAccount acc1 = b.getAccounts().get(FirstAccountNumber);
		PersistentAccount acc2 = b.getAccounts().get(SecondAccountNumber);
		
		PersistentTransfer action = acc2.createTransfer();
		action.setSubject("Folge 2->1");
		action.setMoney(Money.createMoney(Amount.createAmount(Fraction.parseDec("12")), Euro.getTheEuro()));
		action.setReceiverAccountNumber(acc1.getAccountNumber());
		action.setReceiverBankNumber(acc1.getBank().getBankNumber());
		PersistentTrigger tr = acc2.createTrigger("T2",action);
		tr.addRule(SubjectRule.createSubjectRule());
		tr.enable();
		
		PersistentTransfer action2 = acc1.createTransfer();
		action2.setSubject("Folge 1->2");
		action2.setReceiverAccountNumber(acc2.getAccountNumber());
		action2.setReceiverBankNumber(acc2.getBank().getBankNumber());
		action2.setMoney(Money.createMoney(Amount.createAmount(Fraction.parseDec("13")), Euro.getTheEuro()));
		PersistentTrigger tr2 = acc1.createTrigger("T1",action2);
		tr2.addRule(SubjectRule.createSubjectRule());
		tr2.enable();
		
		
		
		
		
	}

}

