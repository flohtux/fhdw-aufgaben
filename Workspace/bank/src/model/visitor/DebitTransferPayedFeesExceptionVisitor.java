
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferPayedFeesExceptionVisitor<E extends UserException> {
    
    public void handleNoPayedFees(PersistentNoPayedFees noPayedFees) throws PersistenceException, E;
    public void handleDebitTransferPayedFees(PersistentDebitTransferPayedFees debitTransferPayedFees) throws PersistenceException, E;
    
}
