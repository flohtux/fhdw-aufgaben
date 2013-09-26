
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferPayedFeesReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleNoPayedFees(PersistentNoPayedFees noPayedFees) throws PersistenceException, E;
    public R handleDebitTransferPayedFees(PersistentDebitTransferPayedFees debitTransferPayedFees) throws PersistenceException, E;
    
}
