
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferTransactionReturnExceptionVisitor<R, E extends UserException> extends DebitTransferReturnExceptionVisitor<R, E> {
    
    public R handleTransaction(PersistentTransaction transaction) throws PersistenceException, E;
    
}
