
package model.visitor;

import persistence.*;

public interface DebitTransferReturnVisitor<R> {
    
    public R handleTransfer(PersistentTransfer transfer) throws PersistenceException;
    public R handleDebit(PersistentDebit debit) throws PersistenceException;
    
}
