package test;



import junit.framework.TestCase;
import model.Administrator;
import model.Bank;
import model.BankCreator;
import persistence.PersistenceException;
import persistence.PersistentAdministrator;
import persistence.PersistentBank;

public class testTest extends TestCase {
	//TODO PREREQUISITES: Test: How to prepare tests
	public void setUp(){
		try {
			TestSupport.prepareDatabase(); //TODO PREREQUISITES: Test: substitute by following statement for database-less test: ConnectionHandler.getTheConnectionHandler().connect("", "", "", null, false);
			TestSupport.prepareSingletons();
			persistence.Cache.getTheCache().reset$For$Test();
		} catch (Exception e) {
			e.printStackTrace();
		} 	
	}
	//TODO PREREQUISITES: Test: test synchronous server operations only!
	public void test() {
		final String BankName = "Bank1";
		try {
			PersistentAdministrator admin = Administrator.createAdministrator();
			BankCreator.getTheBankCreator().createBank(BankName,admin);
			final long FirstBankNumber = serverConstants.ServerConstants.FirstBankNumber + 1;
			PersistentBank bank = Bank.getBankByBankNumber(FirstBankNumber).iterator().next();
			assertEquals(BankName, bank.getName());
			final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
			bank.createAccount("Euro");
	        //TODO PREREQUISITES: Hashmap: how to get things out of HashMaps!
			assertEquals(2, bank.getAccounts().get(FirstAccountNumber).getAccountNumber());
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

}
