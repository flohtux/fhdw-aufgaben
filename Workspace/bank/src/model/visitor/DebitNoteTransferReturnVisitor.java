
package model.visitor;

import persistence.*;

public interface DebitNoteTransferReturnVisitor<R> {
    
    public R handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException;
    public R handleTransfer(PersistentTransfer transfer) throws PersistenceException;
    
}
