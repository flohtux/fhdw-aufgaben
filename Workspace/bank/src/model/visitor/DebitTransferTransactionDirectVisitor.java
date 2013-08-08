
package model.visitor;

import persistence.*;

public abstract class DebitTransferTransactionDirectVisitor implements DebitTransferTransactionVisitor {
    
    public abstract void handleTransaction(PersistentTransaction transaction) throws PersistenceException;
    
    public abstract void handleDebitTransfer(PersistentDebitTransfer debitTransfer) throws PersistenceException;
    
    public void handleDebit(PersistentDebit debit) throws PersistenceException{
        this.handleDebitTransfer(debit);
    }
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.handleDebitTransfer(transfer);
    }
    
}
