
package model.visitor;

import persistence.*;

public interface DebitTransferVisitor {
    
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException;
    public void handleDebit(PersistentDebit debit) throws PersistenceException;
    
}
