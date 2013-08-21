
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountServiceCommandExceptionVisitor<E extends UserException> {
    
    public void handleExecuteTransferCommand(PersistentExecuteTransferCommand executeTransferCommand) throws PersistenceException, E;
    
}
