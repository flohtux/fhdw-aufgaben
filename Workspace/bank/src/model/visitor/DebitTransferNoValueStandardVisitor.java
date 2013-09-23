
package model.visitor;

import persistence.*;

public abstract class DebitTransferNoValueStandardVisitor implements DebitTransferNoValueVisitor {
    
    public void handleNoDebitTransfer(PersistentNoDebitTransfer noDebitTransfer) throws PersistenceException{
        this.standardHandling(noDebitTransfer);
    }
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    public void handleDebit(PersistentDebit debit) throws PersistenceException{
        this.standardHandling(debit);
    }
    protected abstract void standardHandling(DebitTransferNoValue debitTransferNoValue) throws PersistenceException;
}
