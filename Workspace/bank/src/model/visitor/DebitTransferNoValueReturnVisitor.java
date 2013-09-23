
package model.visitor;

import persistence.*;

public interface DebitTransferNoValueReturnVisitor<R> extends DebitTransferReturnVisitor<R> {
    
    public R handleNoDebitTransfer(PersistentNoDebitTransfer noDebitTransfer) throws PersistenceException;
    
}
