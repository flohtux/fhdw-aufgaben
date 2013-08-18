
package model.visitor;

import persistence.*;

public abstract class ObsInterfaceStandardVisitor implements ObsInterfaceVisitor {
    
    public void handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException{
        this.standardHandling(accountDebitTransferTransactions);
    }
    public void handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException{
        this.standardHandling(administratorCurrencyManager);
    }
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException{
        this.standardHandling(administratorBanks);
    }
    protected abstract void standardHandling(ObsInterface obsInterface) throws PersistenceException;
}
