
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitNoteTransferTransactionExceptionVisitor<E extends UserException> extends DebitNoteTransferExceptionVisitor<E>{
    
    public void handleTransaction(PersistentTransaction transaction) throws PersistenceException, E;
    
}
