
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleTransfer(PersistentTransfer transfer) throws PersistenceException, E;
    public R handleDebit(PersistentDebit debit) throws PersistenceException, E;
    
}
