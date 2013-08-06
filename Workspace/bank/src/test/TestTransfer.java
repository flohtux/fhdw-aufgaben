package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import model.Administrator;
import model.Amount;
import model.Bank;
import model.BankCreator;
import model.Euro;
import model.FixTransactionFee;
import model.InvalidAccountNumberException;
import model.InvalidBankNumberException;
import model.Limit;
import model.LimitAccount;
import model.LimitViolatedException;
import model.Money;

import org.junit.Test;

import common.Fraction;

import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAdministrator;
import persistence.PersistentBank;
import persistence.PersistentLimitAccount;
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
	
    public void testBankintern() {
                    final String BankName = "Bank1";
                    try {
                    		PersistentAdministrator admin = Administrator.createAdministrator();
                    		
                            PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName,admin);
//                            admin.getBanks().add(bank);
//                            bank.setAdministrator(admin);
                            long bankNumber = bank.getBankNumber();
                            final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
                            final long SecondAccountNumber = FirstAccountNumber + 1;
                            bank.createAccount("Euro");
                            bank.createAccount("Euro");
                                                                                   
                            PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
                            PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
                            
                            
                            PersistentTransfer newTrans = acc1.createTransfer();
                            newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10,1)), Euro.getTheEuro()));
                            newTrans.setReceiverAccountNumber(SecondAccountNumber);
                            newTrans.setReceiverBankNumber(bankNumber);
                            try {
								try {
									newTrans.execute();
								} catch (LimitViolatedException e) {
									fail();
									e.printStackTrace();
								}
							} catch (InvalidBankNumberException e) {
								fail();
								e.printStackTrace();
							} catch (InvalidAccountNumberException e) {
								fail();
								e.printStackTrace();
							}
                           
                            assertEquals(new Fraction(10,1), acc2.getMoney().getAmount().getBalance());
                            assertEquals(new Fraction(-10,1), acc1.getMoney().getAmount().getBalance());
                              
                    } catch (PersistenceException e) {
                            e.printStackTrace();
                    }
            }
    
    public void testLimits() {
        final String BankName = "Bank1";
        try {
        	 PersistentAdministrator adminTestLimits = Administrator.createAdministrator();
             
             PersistentBank bankTestLimits = BankCreator.getTheBankCreator().createBank(BankName,adminTestLimits);
//             adminTestLimits.getBanks().add(bankTestLimits);
//             bankTestLimits.setAdministrator(adminTestLimits);
             long bankNumber = bankTestLimits.getBankNumber();
             bankTestLimits.createAccount("Euro");
             bankTestLimits.createAccount("Euro");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             final long SecondAccountNumber = FirstAccountNumber + 1;                                                       
             
             PersistentAccount acc1 = bankTestLimits.getAccounts().get(FirstAccountNumber);
             PersistentAccount acc2 = bankTestLimits.getAccounts().get(SecondAccountNumber);
             
                PersistentLimitAccount limit1 = LimitAccount.createLimitAccount();
                limit1.setMinLimit(Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(0, 1)), Euro.getTheEuro())));
                acc1.setLimit(limit1);
                
                
                
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10,1)), Euro.getTheEuro()));
                newTrans.setReceiverAccountNumber(SecondAccountNumber);
                newTrans.setReceiverBankNumber(bankNumber);
                try {
                	newTrans.execute();
				} catch (InvalidBankNumberException e) {
					fail();
					e.printStackTrace();
				} catch (InvalidAccountNumberException e) {
					fail();
				e.printStackTrace();
				} catch (LimitViolatedException e) {
					assertTrue(true);
					return;
				}
                fail("Es hätte ein Fehler auftreten sollen, weil Limit überschritten!!!");
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
}
    
    public void testLimitsMax() {
        final String BankName = "Bank1";
        try {
         PersistentAdministrator admin = Administrator.createAdministrator();
        
                PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName,admin);
//                admin.getBanks().add(bank);
//                bank.setAdministrator(admin);
                long bankNumber = bank.getBankNumber();
                bank.createAccount("Euro");
                bank.createAccount("Euro");
                final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
                final long SecondAccountNumber = FirstAccountNumber + 1;                                                       
                
                PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
                
                PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
                PersistentLimitAccount limit1 = LimitAccount.createLimitAccount();
                limit1.setMaxLimit(Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(10, 1)), Euro.getTheEuro())));
                acc2.setLimit(limit1);
                
                
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(100,1)), Euro.getTheEuro()));
                newTrans.setReceiverAccountNumber(SecondAccountNumber);
                newTrans.setReceiverBankNumber(bankNumber);
                try {
                	newTrans.execute();
				} catch (InvalidBankNumberException e) {
					fail();
				e.printStackTrace();
				} catch (InvalidAccountNumberException e) {
					fail();
				e.printStackTrace();
				} catch (LimitViolatedException e) {
					assertTrue(true);
					return;
				}
                	fail("Es hätte ein Fehler auftreten sollen, weil Limit überschritten!!!");
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
}
    
    public void testBankExtern() {
        final String BankName1 = "Bank1";
        final String BankName2 = "Bank2";
        try {
        	 PersistentAdministrator adminTestLimits = Administrator.createAdministrator();
             
             PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1,adminTestLimits);
             PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2,adminTestLimits);
             bank1.setFee(FixTransactionFee.createFixTransactionFee(Money.createMoney(Amount.createAmount(new Fraction(1, 1)), Euro.getTheEuro())));
//             adminTestLimits.getBanks().add(bankTestLimits);
//             bankTestLimits.setAdministrator(adminTestLimits);
             long bankNumber1 = bank1.getBankNumber();
             long bankNumber2 = bank2.getBankNumber();
             bank1.createAccount("Euro");
             bank2.createAccount("Euro");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             final long SecondAccountNumber = FirstAccountNumber + 1;                                                       
             
             PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
             PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
             
//                PersistentLimitAccount limit1 = LimitAccount.createLimitAccount();
//                limit1.setMinLimit(Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(0, 1)), Euro.getTheEuro())));
//                acc1.setLimit(limit1);
                
                
                
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10,1)), Euro.getTheEuro()));
                newTrans.setReceiverAccountNumber(FirstAccountNumber);
                newTrans.setReceiverBankNumber(bankNumber2);
                try {
                	newTrans.execute();
				} catch (InvalidBankNumberException e) {
					fail();
					e.printStackTrace();
				} catch (InvalidAccountNumberException e) {
					fail();
				e.printStackTrace();
				} catch (LimitViolatedException e) {
					fail();
					return;
				}
                assertEquals(new Fraction(-11, 1), acc1.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(10, 1), acc2.getMoney().getAmount().getBalance());
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
}

}

