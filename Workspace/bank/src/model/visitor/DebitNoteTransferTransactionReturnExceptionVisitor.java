
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitNoteTransferTransactionReturnExceptionVisitor<R, E extends UserException> extends DebitNoteTransferReturnExceptionVisitor<R, E> {
    
    public R handleTransaction(PersistentTransaction transaction) throws PersistenceException, E;
    
}
