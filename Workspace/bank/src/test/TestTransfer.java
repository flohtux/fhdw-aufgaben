package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import model.Administrator;
import model.Amount;
import model.Bank;
import model.BankCreator;
import model.Euro;
import model.InvalidAccountNumberException;
import model.InvalidBankNumberException;
import model.Money;

import org.junit.Test;

import common.Fraction;

import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAdministrator;
import persistence.PersistentBank;
import persistence.PersistentTransfer;

public class TestTransfer extends TestCase{

	public void setUp(){
		try {
			TestSupport.prepareDatabase(); //TODO PREREQUISITES: Test: substitute by following statement for database-less test: ConnectionHandler.getTheConnectionHandler().connect("", "", "", null, false);
			TestSupport.prepareSingletons();
			persistence.Cache.getTheCache().reset$For$Test();
		} catch (Exception e) {
			e.printStackTrace();
		} 	
	}
	
    public void test() {
                    final String BankName = "Bank1";
                    final String Acc1Name = "Acc1";
                    final String Acc2Name = "Acc2";
                    try {
                    		PersistentAdministrator admin = Administrator.createAdministrator();
                    		
                            PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName);
                            admin.getBanks().add(bank);
                            bank.setAdministrator(admin);
                            long bankNumber = bank.getBankNumber();
                            final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
                            final long SecondAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
                            bank.createAccount("Euro");
                            bank.createAccount("Dollar");
                                                                                   
                            PersistentAccount acc1 = bank.getAccounts().get(1);
                            PersistentAccount acc2 = bank.getAccounts().get(2);
                            
                            
                            PersistentTransfer newTrans = acc1.createTransfer();
                            newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10,1)), Euro.getTheEuro()));
                            newTrans.setReceiverAccountNumber(2);
                            newTrans.setReceiverBankNumber(bankNumber);
                            try {
								newTrans.execute();
							} catch (InvalidBankNumberException e) {
								fail();
								e.printStackTrace();
							} catch (InvalidAccountNumberException e) {
								fail();
								e.printStackTrace();
							}
                           
                            assertEquals(new Fraction(10,1), acc2.getMoney().getAmount().getBalance());
                              
                    } catch (PersistenceException e) {
                            e.printStackTrace();
                    }
            }

}
