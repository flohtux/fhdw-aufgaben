
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitTransferTransactionCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException, E;
    
}
