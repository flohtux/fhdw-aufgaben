
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferTransactionExceptionVisitor<E extends UserException> extends DebitTransferExceptionVisitor<E>{
    
    public void handleTransaction(PersistentTransaction transaction) throws PersistenceException, E;
    
}
