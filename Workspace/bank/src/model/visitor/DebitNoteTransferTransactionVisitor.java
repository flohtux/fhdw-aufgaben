
package model.visitor;

import persistence.*;

public interface DebitNoteTransferTransactionVisitor extends DebitNoteTransferVisitor{
    
    public void handleTransaction(PersistentTransaction transaction) throws PersistenceException;
    
}
