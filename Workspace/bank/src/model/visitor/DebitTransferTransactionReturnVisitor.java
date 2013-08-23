
package model.visitor;

import persistence.*;

public interface DebitTransferTransactionReturnVisitor<R> extends DebitTransferReturnVisitor<R> {
    
    public R handleTransaction(PersistentTransaction transaction) throws PersistenceException;
    
}
