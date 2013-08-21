
package model.visitor;

import persistence.*;

public interface AccountServiceCommandReturnVisitor<R> {
    
    public R handleExecuteTransferCommand(PersistentExecuteTransferCommand executeTransferCommand) throws PersistenceException;
    
}
