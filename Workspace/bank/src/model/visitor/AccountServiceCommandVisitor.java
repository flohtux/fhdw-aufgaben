
package model.visitor;

import persistence.*;

public interface AccountServiceCommandVisitor {
    
    public void handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException;
    public void handleExecuteTransferCommand(PersistentExecuteTransferCommand executeTransferCommand) throws PersistenceException;
    
}
