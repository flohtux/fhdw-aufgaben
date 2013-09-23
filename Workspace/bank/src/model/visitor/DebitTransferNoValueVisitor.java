
package model.visitor;

import persistence.*;

public interface DebitTransferNoValueVisitor extends DebitTransferVisitor{
    
    public void handleNoDebitTransfer(PersistentNoDebitTransfer noDebitTransfer) throws PersistenceException;
    
}
