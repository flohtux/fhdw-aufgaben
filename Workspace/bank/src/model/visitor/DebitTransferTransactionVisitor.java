
package model.visitor;

import persistence.*;

public interface DebitTransferTransactionVisitor extends DebitTransferVisitor{
    
    public void handleTransaction(PersistentTransaction transaction) throws PersistenceException;
    
}
