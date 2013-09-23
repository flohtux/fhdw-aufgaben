
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferNoValueReturnExceptionVisitor<R, E extends UserException> extends DebitTransferReturnExceptionVisitor<R, E> {
    
    public R handleNoDebitTransfer(PersistentNoDebitTransfer noDebitTransfer) throws PersistenceException, E;
    
}
