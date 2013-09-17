
package model.visitor;
import model.UserException;
import persistence.*;

public interface CompensationCommandExceptionVisitor<E extends UserException> {
    
    public void handleExecuteCompensationCommand(PersistentExecuteCompensationCommand executeCompensationCommand) throws PersistenceException, E;
    
}
