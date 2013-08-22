
package model.visitor;

import persistence.*;

public interface ObsInterfaceVisitor {
    
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException;
    public void handleAccountServiceSuccessful(PersistentAccountServiceSuccessful accountServiceSuccessful) throws PersistenceException;
    public void handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException;
    public void handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException;
    public void handleAccountServiceNotExecuted(PersistentAccountServiceNotExecuted accountServiceNotExecuted) throws PersistenceException;
    
}
