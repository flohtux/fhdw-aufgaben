
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferNoValueExceptionVisitor<E extends UserException> extends DebitTransferExceptionVisitor<E>{
    
    public void handleNoDebitTransfer(PersistentNoDebitTransfer noDebitTransfer) throws PersistenceException, E;
    
}
