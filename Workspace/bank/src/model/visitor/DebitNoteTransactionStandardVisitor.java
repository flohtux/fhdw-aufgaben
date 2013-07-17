
package model.visitor;

import persistence.*;

public abstract class DebitNoteTransactionStandardVisitor implements DebitNoteTransactionVisitor {
    
    public void handleTrancaction(PersistentTrancaction trancaction) throws PersistenceException{
        this.standardHandling(trancaction);
    }
    public void handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException{
        this.standardHandling(debitNote);
    }
    protected abstract void standardHandling(PersistentDebitNoteTransaction debitNoteTransaction) throws PersistenceException;
}
