
package model.visitor;

import persistence.*;

public interface DebitNoteTransferVisitor {
    
    public void handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException;
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException;
    
}
