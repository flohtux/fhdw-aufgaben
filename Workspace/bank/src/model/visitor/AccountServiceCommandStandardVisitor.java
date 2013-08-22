
package model.visitor;

import persistence.*;

public abstract class AccountServiceCommandStandardVisitor implements AccountServiceCommandVisitor {
    
    public void handleExecuteTransferCommand(PersistentExecuteTransferCommand executeTransferCommand) throws PersistenceException{
        this.standardHandling(executeTransferCommand);
    }
    public void handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException{
        this.standardHandling(createDebitGrantCommand);
    }
    protected abstract void standardHandling(AccountServiceCommand accountServiceCommand) throws PersistenceException;
}
