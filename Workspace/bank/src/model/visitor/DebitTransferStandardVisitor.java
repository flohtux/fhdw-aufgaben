
package model.visitor;

import persistence.*;

public abstract class DebitTransferStandardVisitor implements DebitTransferVisitor {
    
    public void handleDebit(PersistentDebit debit) throws PersistenceException{
        this.standardHandling(debit);
    }
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    protected abstract void standardHandling(PersistentDebitTransfer debitTransfer) throws PersistenceException;
}
