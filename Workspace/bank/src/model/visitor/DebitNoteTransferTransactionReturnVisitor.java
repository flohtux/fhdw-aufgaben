
package model.visitor;

import persistence.*;

public interface DebitNoteTransferTransactionReturnVisitor<R> extends DebitNoteTransferReturnVisitor<R> {
    
    public R handleTransaction(PersistentTransaction transaction) throws PersistenceException;
    
}
