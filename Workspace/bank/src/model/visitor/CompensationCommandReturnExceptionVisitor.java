
package model.visitor;
import model.UserException;
import persistence.*;

public interface CompensationCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleExecuteCompensationCommand(PersistentExecuteCompensationCommand executeCompensationCommand) throws PersistenceException, E;
    
}
