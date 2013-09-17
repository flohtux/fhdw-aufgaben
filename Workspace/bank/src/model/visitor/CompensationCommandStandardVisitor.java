
package model.visitor;

import persistence.*;

public abstract class CompensationCommandStandardVisitor implements CompensationCommandVisitor {
    
    public void handleExecuteCompensationCommand(PersistentExecuteCompensationCommand executeCompensationCommand) throws PersistenceException{
        this.standardHandling(executeCompensationCommand);
    }
    protected abstract void standardHandling(CompensationCommand compensationCommand) throws PersistenceException;
}
