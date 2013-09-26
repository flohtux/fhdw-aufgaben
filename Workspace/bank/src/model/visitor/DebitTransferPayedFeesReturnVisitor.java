
package model.visitor;

import persistence.*;

public interface DebitTransferPayedFeesReturnVisitor<R> {
    
    public R handleNoPayedFees(PersistentNoPayedFees noPayedFees) throws PersistenceException;
    public R handleDebitTransferPayedFees(PersistentDebitTransferPayedFees debitTransferPayedFees) throws PersistenceException;
    
}
