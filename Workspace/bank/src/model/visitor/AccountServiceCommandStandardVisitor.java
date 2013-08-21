
package model.visitor;

import persistence.*;

public abstract class AccountServiceCommandStandardVisitor implements AccountServiceCommandVisitor {
    
    public void handleExecuteTransferCommand(PersistentExecuteTransferCommand executeTransferCommand) throws PersistenceException{
        this.standardHandling(executeTransferCommand);
    }
    protected abstract void standardHandling(AccountServiceCommand accountServiceCommand) throws PersistenceException;
}
