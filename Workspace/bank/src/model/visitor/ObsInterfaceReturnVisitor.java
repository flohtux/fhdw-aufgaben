
package model.visitor;

import persistence.*;

public interface ObsInterfaceReturnVisitor<R> {
    
    public R handleAccountServiceSuccessfullStates(PersistentAccountServiceSuccessfullStates accountServiceSuccessfullStates) throws PersistenceException;
    public R handleAccountServiceNotSuccessfullStates(PersistentAccountServiceNotSuccessfullStates accountServiceNotSuccessfullStates) throws PersistenceException;
    public R handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException;
    public R handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException;
    public R handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException;
    
}
