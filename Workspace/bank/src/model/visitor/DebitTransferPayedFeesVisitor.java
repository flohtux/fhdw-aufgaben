
package model.visitor;

import persistence.*;

public interface DebitTransferPayedFeesVisitor {
    
    public void handleNoPayedFees(PersistentNoPayedFees noPayedFees) throws PersistenceException;
    public void handleDebitTransferPayedFees(PersistentDebitTransferPayedFees debitTransferPayedFees) throws PersistenceException;
    
}
