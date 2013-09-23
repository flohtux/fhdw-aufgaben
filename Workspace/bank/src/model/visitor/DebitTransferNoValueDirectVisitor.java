
package model.visitor;

import persistence.*;

public abstract class DebitTransferNoValueDirectVisitor implements DebitTransferNoValueVisitor {
    
    public abstract void handleDebitTransfer(PersistentDebitTransfer debitTransfer) throws PersistenceException;
    
    public void handleDebit(PersistentDebit debit) throws PersistenceException{
        this.handleDebitTransfer(debit);
    }
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.handleDebitTransfer(transfer);
    }
    public abstract void handleNoDebitTransfer(PersistentNoDebitTransfer noDebitTransfer) throws PersistenceException;
    
    
}
