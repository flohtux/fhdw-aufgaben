
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountServiceCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException, E;
    public void handleExecuteTransferCommand(PersistentExecuteTransferCommand executeTransferCommand) throws PersistenceException, E;
    
}
