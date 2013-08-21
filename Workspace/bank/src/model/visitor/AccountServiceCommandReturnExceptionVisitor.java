
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountServiceCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleExecuteTransferCommand(PersistentExecuteTransferCommand executeTransferCommand) throws PersistenceException, E;
    
}
