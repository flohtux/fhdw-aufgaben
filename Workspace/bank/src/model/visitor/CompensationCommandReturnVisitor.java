
package model.visitor;

import persistence.*;

public interface CompensationCommandReturnVisitor<R> {
    
    public R handleExecuteCompensationCommand(PersistentExecuteCompensationCommand executeCompensationCommand) throws PersistenceException;
    
}
