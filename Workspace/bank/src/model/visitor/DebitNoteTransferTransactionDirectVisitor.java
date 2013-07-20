
package model.visitor;

import persistence.*;

public abstract class DebitNoteTransferTransactionDirectVisitor implements DebitNoteTransferTransactionVisitor {
    
    public abstract void handleTransaction(PersistentTransaction transaction) throws PersistenceException;
    
    public abstract void handleDebitNoteTransfer(PersistentDebitNoteTransfer debitNoteTransfer) throws PersistenceException;
    
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.handleDebitNoteTransfer(transfer);
    }
    public void handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException{
        this.handleDebitNoteTransfer(debitNote);
    }
    
}
