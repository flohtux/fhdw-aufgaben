
package model.visitor;

import persistence.*;

public abstract class DebitNoteTransferTransactionStandardVisitor implements DebitNoteTransferTransactionVisitor {
    
    public void handleTransaction(PersistentTransaction transaction) throws PersistenceException{
        this.standardHandling(transaction);
    }
    public void handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException{
        this.standardHandling(debitNote);
    }
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    protected abstract void standardHandling(PersistentDebitNoteTransferTransaction debitNoteTransferTransaction) throws PersistenceException;
}
