package test;

import java.util.Currency;

import junit.framework.TestCase;

import model.Administrator;
import model.Amount;
import model.BankCreator;
import model.CurrencyManager;
import model.Dollar;
import model.Euro;
import model.FixTransactionFee;
import model.InvalidAccountNumberException;
import model.InvalidBankNumberException;
import model.Limit;
import model.LimitAccount;
import model.LimitViolatedException;
import model.MixedFee;
import model.Money;
import model.NoPermissionToExecuteDebitTransferException;
import model.Percent;
import model.Pfund;
import model.ProcentualFee;


import common.Fraction;

import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAdministrator;
import persistence.PersistentBank;
import persistence.PersistentFixTransactionFee;
import persistence.PersistentLimitAccount;
import persistence.PersistentProcentualFee;
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
							}catch (NoPermissionToExecuteDebitTransferException e) {
								fail();
								e.printStackTrace();
							}
                           
                            assertEquals(new Fraction(10,1), acc2.getMoney().getAmount().getBalance());
                            assertEquals(new Fraction(-10,1), acc1.getMoney().getAmount().getBalance());
                              
                    } catch (PersistenceException e) {
                            e.printStackTrace();
                    }
            }
    
    public void testBankinternOtherCurrencies() {
        final String BankName = "Bank1";
        try {
        		PersistentAdministrator admin = Administrator.createAdministrator();
        		
                PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName,admin);
                long bankNumber = bank.getBankNumber();
                final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
                final long SecondAccountNumber = FirstAccountNumber + 1;
                bank.createAccount("Euro");
                bank.createAccount("Euro");
                                                                       
                PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
                PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
                
                
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(10,1)), Dollar.getTheDollar()));
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
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
             long bankNumber = bankTestLimits.getBankNumber();
             bankTestLimits.createAccount("Euro");
             bankTestLimits.createAccount("Euro");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             final long SecondAccountNumber = FirstAccountNumber + 1;                                                       
             
             PersistentAccount acc1 = bankTestLimits.getAccounts().get(FirstAccountNumber);
             
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
                	fail("Es hätte ein Fehler auftreten sollen, weil Limit überschritten!!!");
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
}
    
    public void testBankExternFixFee() {
        final String BankName1 = "Bank1";
        final String BankName2 = "Bank2";
        try {
        	 PersistentAdministrator adminTestLimits = Administrator.createAdministrator();
             
             PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1,adminTestLimits);
             PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2,adminTestLimits);
             bank1.setFee(FixTransactionFee.createFixTransactionFee(Money.createMoney(Amount.createAmount(new Fraction(1, 1)), Euro.getTheEuro())));
             long bankNumber2 = bank2.getBankNumber();
             bank1.createAccount("Euro");
             bank2.createAccount("Euro");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             
             PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
             PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
             
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
                assertEquals(new Fraction(-11, 1), acc1.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(10, 1), acc2.getMoney().getAmount().getBalance());
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
}

    public void testBankExternProcentualFee() {
        final String BankName1 = "Bank1";
        final String BankName2 = "Bank2";
        try {
        	 PersistentAdministrator adminTestLimits = Administrator.createAdministrator();
             
             PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1,adminTestLimits);
             PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2,adminTestLimits);
             bank1.setFee(ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 2))));
             long bankNumber2 = bank2.getBankNumber();
             bank1.createAccount("Euro");
             bank2.createAccount("Euro");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             
             PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
             PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
             
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
                assertEquals(new Fraction(-15, 1), acc1.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(10, 1), acc2.getMoney().getAmount().getBalance());
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
}
    
    public void testBankExternMixedFee() {
        final String BankName1 = "Bank1";
        final String BankName2 = "Bank2";
        try {
        	 PersistentAdministrator adminTestLimits = Administrator.createAdministrator();
             
             PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1,adminTestLimits);
             PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2,adminTestLimits);
             PersistentProcentualFee procentualFee = ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 2)));
             PersistentFixTransactionFee fixFee = FixTransactionFee.createFixTransactionFee(Money.createMoney(
            		 Amount.createAmount(new Fraction(3, 1)), Euro.getTheEuro()));
             bank1.setFee(MixedFee.createMixedFee(fixFee, procentualFee, Money.createMoney(
               		 Amount.createAmount(new Fraction(5, 1)), Euro.getTheEuro())));
             long bankNumber2 = bank2.getBankNumber();
             bank1.createAccount("Euro");
             bank2.createAccount("Euro");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             
             PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
             PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
             
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(11,1)), Euro.getTheEuro()));
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
                assertEquals(new Fraction(-17, 1), acc1.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(11, 1), acc2.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(6, 1), bank1.getOwnAccount().getMoney().getAmount().getBalance());
                assertEquals(Fraction.Null, bank2.getOwnAccount().getMoney().getAmount().getBalance());
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
}
    

    public void testBankExternProcentualFeeLimitViolation() {
        final String BankName1 = "Bank1";
        final String BankName2 = "Bank2";
        try {
        	 PersistentAdministrator adminTestLimits = Administrator.createAdministrator();
             
             PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1,adminTestLimits);
             PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2,adminTestLimits);
             bank1.setFee(ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 2))));
             long bankNumber2 = bank2.getBankNumber();
             bank1.createAccount("Euro");
             bank2.createAccount("Euro");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             
             PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
             
             PersistentLimitAccount limit = LimitAccount.createLimitAccount();
             limit.setMinLimit(Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(-13, 1)), Euro.getTheEuro())));
             acc1.setLimit(limit);
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
					assertTrue(true);
					return;
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
                fail("Es hätte ein Fehler auftreten sollen, weil Limit überschritten!!!");
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
    }
    
    public void testBankinternNoCharge() {
        final String BankName = "Bank1";
        try {
        		PersistentAdministrator admin = Administrator.createAdministrator();
        		
                PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName,admin);
                long bankNumber = bank.getBankNumber();
                final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
                final long SecondAccountNumber = FirstAccountNumber + 1;
                bank.createAccount("Euro");
                bank.createAccount("Euro");
                                                                       
                PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
                PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
                
                
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(100,1)), Euro.getTheEuro()));
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
               
                assertEquals(new Fraction(100,1), acc2.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(-100,1), acc1.getMoney().getAmount().getBalance());
                assertEquals(Fraction.Null, bank.getOwnAccount().getMoney().getAmount().getBalance());
                  
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
	}
	
	public void testBankinternZeroMoney() {
        final String BankName = "Bank1";
        try {
        		PersistentAdministrator admin = Administrator.createAdministrator();
        		
                PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName,admin);
                long bankNumber = bank.getBankNumber();
                final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
                final long SecondAccountNumber = FirstAccountNumber + 1;
                bank.createAccount("Euro");
                bank.createAccount("Euro");
                                                                       
                PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
                PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
                
                
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(0,1)), Euro.getTheEuro()));
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
               
                assertEquals(new Fraction(0,1), acc2.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(0,1), acc1.getMoney().getAmount().getBalance());
                assertEquals(Fraction.Null, bank.getOwnAccount().getMoney().getAmount().getBalance());
                  
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
	}
	
	public void testBankExternNoCharge() {
        final String BankName1 = "Bank1";
        final String BankName2 = "Bank2";
        try {
        	 PersistentAdministrator adminTestLimits = Administrator.createAdministrator();
             
             PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1,adminTestLimits);
             PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2,adminTestLimits);
             long bankNumber2 = bank2.getBankNumber();
             bank1.createAccount("Euro");
             bank2.createAccount("Euro");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             
             PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
             PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
             
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
                
                assertEquals(new Fraction(-10, 1), acc1.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(10, 1), acc2.getMoney().getAmount().getBalance());
                assertEquals(Fraction.Null, bank1.getOwnAccount().getMoney().getAmount().getBalance());
                assertEquals(Fraction.Null, bank2.getOwnAccount().getMoney().getAmount().getBalance());
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
	}
	
	public void testBankExternFixFee2() {
        final String BankName1 = "Bank1";
        final String BankName2 = "Bank2";
        try {
        	 PersistentAdministrator adminTestLimits = Administrator.createAdministrator();
             
             PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1,adminTestLimits);
             PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2,adminTestLimits);
             bank1.setFee(FixTransactionFee.createFixTransactionFee(Money.createMoney(Amount.createAmount(new Fraction(5, 1)), Euro.getTheEuro())));
             long bankNumber2 = bank2.getBankNumber();
             bank1.createAccount("Euro");
             bank2.createAccount("Euro");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             
             PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
             PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
             
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(100,1)), Euro.getTheEuro()));
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
                
                assertEquals(new Fraction(-105, 1), acc1.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(100, 1), acc2.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(5, 1), bank1.getOwnAccount().getMoney().getAmount().getBalance());
                assertEquals(Fraction.Null, bank2.getOwnAccount().getMoney().getAmount().getBalance());
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
	}
	
	public void testBankinternFixFee() {
        final String BankName = "Bank1";
        try {
        		PersistentAdministrator admin = Administrator.createAdministrator();
        		
                PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName,admin);
                bank.setFee(FixTransactionFee.createFixTransactionFee(Money.createMoney(Amount.createAmount(new Fraction(5, 1)), Euro.getTheEuro())));
                long bankNumber = bank.getBankNumber();
                final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
                final long SecondAccountNumber = FirstAccountNumber + 1;
                bank.createAccount("Euro");
                bank.createAccount("Euro");
                                                                       
                PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
                PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
                
                
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(100,1)), Euro.getTheEuro()));
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
               
                assertEquals(new Fraction(100,1), acc2.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(-105,1), acc1.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(5,1), bank.getOwnAccount().getMoney().getAmount().getBalance());
                  
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
	}
	
	public void testBankExternProcentualFee2() {
        final String BankName1 = "Bank1";
        final String BankName2 = "Bank2";
        try {
        	 PersistentAdministrator adminTestLimits = Administrator.createAdministrator();
             
             PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1,adminTestLimits);
             PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2,adminTestLimits);
             bank1.setFee(ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 20))));
             long bankNumber2 = bank2.getBankNumber();
             bank1.createAccount("Euro");
             bank2.createAccount("Euro");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             
             PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
             PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
             
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(200,1)), Euro.getTheEuro()));
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
                assertEquals(new Fraction(-210, 1), acc1.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(200, 1), acc2.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(10, 1), bank1.getOwnAccount().getMoney().getAmount().getBalance());
                assertEquals(Fraction.Null, bank2.getOwnAccount().getMoney().getAmount().getBalance());
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
	}
	
	public void testBankinternProcentualFee() {
        final String BankName = "Bank1";
        try {
        		PersistentAdministrator admin = Administrator.createAdministrator();
        		
                PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName,admin);
                bank.setFee(ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 20))));
                long bankNumber = bank.getBankNumber();
                final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
                final long SecondAccountNumber = FirstAccountNumber + 1;
                bank.createAccount("Euro");
                bank.createAccount("Euro");
                                                                       
                PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
                PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
                
                
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(200,1)), Euro.getTheEuro()));
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
               
                assertEquals(new Fraction(200,1), acc2.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(-210,1), acc1.getMoney().getAmount().getBalance());
                  
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
	}
	
	public void testBankExternMixedFee2() {
        final String BankName1 = "Bank1";
        final String BankName2 = "Bank2";
        try {
        	 PersistentAdministrator adminTestLimits = Administrator.createAdministrator();
             
             PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1,adminTestLimits);
             PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2,adminTestLimits);
             PersistentProcentualFee procentualFee = ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 20)));
             PersistentFixTransactionFee fixFee = FixTransactionFee.createFixTransactionFee(Money.createMoney(
            		 Amount.createAmount(new Fraction(5, 1)), Euro.getTheEuro()));
             bank1.setFee(MixedFee.createMixedFee(fixFee, procentualFee, Money.createMoney(
               		 Amount.createAmount(new Fraction(50, 1)), Euro.getTheEuro())));
             long bankNumber2 = bank2.getBankNumber();
             bank1.createAccount("Euro");
             bank2.createAccount("Euro");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             
             PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
             PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
             
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(150,1)), Euro.getTheEuro()));
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
                assertEquals(new Fraction(-160, 1), acc1.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(150, 1), acc2.getMoney().getAmount().getBalance());
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
	}
	
	public void testBankInternMixFee() {
        final String BankName = "Bank1";
        try {
        		PersistentAdministrator admin = Administrator.createAdministrator();
        		
                PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName,admin);
                PersistentProcentualFee procentualFee = ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 20)));
                PersistentFixTransactionFee fixFee = FixTransactionFee.createFixTransactionFee(Money.createMoney(
               		 Amount.createAmount(new Fraction(5, 1)), Euro.getTheEuro()));
                bank.setFee(MixedFee.createMixedFee(fixFee, procentualFee, Money.createMoney(
                  		 Amount.createAmount(new Fraction(50, 1)), Euro.getTheEuro())));
                long bankNumber = bank.getBankNumber();
                final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
                final long SecondAccountNumber = FirstAccountNumber + 1;
                bank.createAccount("Euro");
                bank.createAccount("Euro");
                                                                       
                PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
                PersistentAccount acc2 = bank.getAccounts().get(SecondAccountNumber);
                
                
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(150,1)), Euro.getTheEuro()));
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
               
                assertEquals(new Fraction(150,1), acc2.getMoney().getAmount().getBalance());
                assertEquals(new Fraction(-160,1), acc1.getMoney().getAmount().getBalance());
                  
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
	}
	
	public void testBankExternFixFeeLimitViolation() {
        final String BankName1 = "Bank1";
        final String BankName2 = "Bank2";
        try {
        	 PersistentAdministrator adminTestLimits = Administrator.createAdministrator();
             
             PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1,adminTestLimits);
             PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2,adminTestLimits);
             bank1.setFee(FixTransactionFee.createFixTransactionFee(Money.createMoney(Amount.createAmount(new Fraction(5, 1)), Euro.getTheEuro())));
             long bankNumber2 = bank2.getBankNumber();
             bank1.createAccount("Euro");
             bank2.createAccount("Euro");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             
             PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
             
             PersistentLimitAccount limit = LimitAccount.createLimitAccount();
             limit.setMinLimit(Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(-50, 1)), Euro.getTheEuro())));
             acc1.setLimit(limit);
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(50,1)), Euro.getTheEuro()));
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
					assertTrue(true);
					return;
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
                fail("Es hätte ein Fehler auftreten sollen, weil Limit überschritten!!!");
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
}
	
	
	public void testBankInternLimitViolation() {
        final String BankName = "Bank1";
        try {
        		PersistentAdministrator admin = Administrator.createAdministrator();
        		
                PersistentBank bank = BankCreator.getTheBankCreator().createBank(BankName,admin);               
                long bankNumber = bank.getBankNumber();
                final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
                final long SecondAccountNumber = FirstAccountNumber + 1;
                bank.createAccount("Euro");
                bank.createAccount("Euro");
                                                                       
                PersistentAccount acc1 = bank.getAccounts().get(FirstAccountNumber);
                
                PersistentLimitAccount limit = LimitAccount.createLimitAccount();
                limit.setMinLimit(Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(-50, 1)), Euro.getTheEuro())));
                acc1.setLimit(limit);
                
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(51,1)), Euro.getTheEuro()));
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
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
                fail("Es hätte ein Fehler auftreten sollen, weil Limit überschritten!!!");
                  
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
	}
	
	public void testBankExternProcentualFeeLimitViolation2() {
        final String BankName1 = "Bank1";
        final String BankName2 = "Bank2";
        try {
        	 PersistentAdministrator adminTestLimits = Administrator.createAdministrator();
             
             PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1,adminTestLimits);
             PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2,adminTestLimits);
             bank1.setFee(ProcentualFee.createProcentualFee(Percent.createPercent(new Fraction(1, 20))));
             long bankNumber2 = bank2.getBankNumber();
             bank1.createAccount("Euro");
             bank2.createAccount("Euro");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             
             PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
             PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
             
             PersistentLimitAccount limit = LimitAccount.createLimitAccount();
             limit.setMaxLimit(Limit.createLimit(Money.createMoney(Amount.createAmount(new Fraction(99, 1)), Euro.getTheEuro())));
             acc2.setLimit(limit);
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(100,1)), Euro.getTheEuro()));
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
					assertTrue(true);
					return;
				}catch (NoPermissionToExecuteDebitTransferException e) {
					fail();
					e.printStackTrace();
				}
                fail("Es hätte ein Fehler auftreten sollen, weil Limit überschritten!!!");
               
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
	}
	
	
	public void testBankExternCurrencyTransfer() throws NoPermissionToExecuteDebitTransferException, InvalidBankNumberException, LimitViolatedException, InvalidAccountNumberException {
        final String BankName1 = "Bank1";
        final String BankName2 = "Bank2";
        try {
        	 PersistentAdministrator adminTestLimits = Administrator.createAdministrator();
        	 
        	 adminTestLimits.changeCurrencyRateGUI("Euro", new Fraction(2, 1));
        	 adminTestLimits.changeCurrencyRateGUI("Dollar", new Fraction(1, 1));
        	 adminTestLimits.changeCurrencyRateGUI("Pfund", new Fraction(3, 1));
             
             PersistentBank bank1 = BankCreator.getTheBankCreator().createBank(BankName1,adminTestLimits);
             PersistentBank bank2 = BankCreator.getTheBankCreator().createBank(BankName2,adminTestLimits);
             long bankNumber2 = bank2.getBankNumber();
             bank1.createAccount("Euro");
             bank2.createAccount("Pfund");
             final long FirstAccountNumber = serverConstants.ServerConstants.FirstAccountNumber + 1;
             
             PersistentAccount acc1 = bank1.getAccounts().get(FirstAccountNumber);
             PersistentAccount acc2 = bank2.getAccounts().get(FirstAccountNumber);
             
                PersistentTransfer newTrans = acc1.createTransfer();
                newTrans.setMoney(Money.createMoney(Amount.createAmount(new Fraction(100,1)), Euro.getTheEuro()));
                newTrans.setReceiverAccountNumber(FirstAccountNumber);
                newTrans.setReceiverBankNumber(bankNumber2);
            	newTrans.execute();
                // TODO equals auf money!!
                assertEquals(Money.createMoney(Amount.createAmount(Fraction.parse("-100")), Euro.getTheEuro()).toString(), acc1.getMoney().toString());
                assertEquals(Money.createMoney(Amount.createAmount(Fraction.parse("150")), Pfund.getThePfund()).toString(), acc2.getMoney().toString());
                
        } catch (PersistenceException e) {
                e.printStackTrace();
        }
	}
    
}

