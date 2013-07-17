
package model.visitor;

import persistence.*;

public interface DebitNoteTransactionVisitor {
    
    public void handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException;
    public void handleTrancaction(PersistentTrancaction trancaction) throws PersistenceException;
    
}
