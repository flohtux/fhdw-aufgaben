
package model.visitor;

import persistence.*;

public interface DebitNoteTransactionReturnVisitor<R> {
    
    public R handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException;
    public R handleTrancaction(PersistentTrancaction trancaction) throws PersistenceException;
    
}
