
package model.visitor;

import persistence.*;

public abstract class ObsInterfaceStandardVisitor implements ObsInterfaceVisitor {
    
    public void handleAccountDebitNoteTransferTransactions(PersistentAccountDebitNoteTransferTransactions accountDebitNoteTransferTransactions) throws PersistenceException{
        this.standardHandling(accountDebitNoteTransferTransactions);
    }
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException{
        this.standardHandling(administratorBanks);
    }
    protected abstract void standardHandling(ObsInterface obsInterface) throws PersistenceException;
}
