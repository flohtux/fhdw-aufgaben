
package model.visitor;

import persistence.*;

public abstract class DebitTransferTransactionStandardVisitor implements DebitTransferTransactionVisitor {
    
    public void handleTransaction(PersistentTransaction transaction) throws PersistenceException{
        this.standardHandling(transaction);
    }
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    public void handleDebit(PersistentDebit debit) throws PersistenceException{
        this.standardHandling(debit);
    }
    protected abstract void standardHandling(PersistentDebitTransferTransaction debitTransferTransaction) throws PersistenceException;
}
