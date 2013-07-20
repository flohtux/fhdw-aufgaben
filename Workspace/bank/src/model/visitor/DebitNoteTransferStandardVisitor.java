
package model.visitor;

import persistence.*;

public abstract class DebitNoteTransferStandardVisitor implements DebitNoteTransferVisitor {
    
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    public void handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException{
        this.standardHandling(debitNote);
    }
    protected abstract void standardHandling(PersistentDebitNoteTransfer debitNoteTransfer) throws PersistenceException;
}
