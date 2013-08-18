
package model.visitor;

import persistence.*;

public interface ObsInterfaceReturnVisitor<R> {
    
    public R handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException;
    public R handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException;
    public R handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException;
    
}
