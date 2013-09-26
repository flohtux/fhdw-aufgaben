
package model.visitor;

import persistence.*;

public abstract class DebitTransferPayedFeesStandardVisitor implements DebitTransferPayedFeesVisitor {
    
    public void handleDebitTransferPayedFees(PersistentDebitTransferPayedFees debitTransferPayedFees) throws PersistenceException{
        this.standardHandling(debitTransferPayedFees);
    }
    public void handleNoPayedFees(PersistentNoPayedFees noPayedFees) throws PersistenceException{
        this.standardHandling(noPayedFees);
    }
    protected abstract void standardHandling(PersistentDebitTransferPayedFees debitTransferPayedFees) throws PersistenceException;
}
