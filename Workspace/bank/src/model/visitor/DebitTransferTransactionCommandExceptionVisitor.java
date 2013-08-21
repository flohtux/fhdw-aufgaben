
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferTransactionCommandExceptionVisitor<E extends UserException> {
    
    public void handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException, E;
    
}
