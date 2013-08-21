
package model.visitor;

import persistence.*;

public interface AccountServiceCommandVisitor {
    
    public void handleExecuteTransferCommand(PersistentExecuteTransferCommand executeTransferCommand) throws PersistenceException;
    
}
