
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferExceptionVisitor<E extends UserException> {
    
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException, E;
    public void handleDebit(PersistentDebit debit) throws PersistenceException, E;
    
}
