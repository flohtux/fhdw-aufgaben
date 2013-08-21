
package model.visitor;

import persistence.*;

public interface ObsInterfaceVisitor {
    
    public void handleAccountServiceSuccessfullStates(PersistentAccountServiceSuccessfullStates accountServiceSuccessfullStates) throws PersistenceException;
    public void handleAccountServiceNotSuccessfullStates(PersistentAccountServiceNotSuccessfullStates accountServiceNotSuccessfullStates) throws PersistenceException;
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException;
    public void handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException;
    public void handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException;
    
}
