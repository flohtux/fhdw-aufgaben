
package model.visitor;

import persistence.*;

public interface CompensationCommandVisitor {
    
    public void handleExecuteCompensationCommand(PersistentExecuteCompensationCommand executeCompensationCommand) throws PersistenceException;
    
}
