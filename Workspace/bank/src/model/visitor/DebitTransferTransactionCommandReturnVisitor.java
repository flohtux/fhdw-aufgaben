
package model.visitor;

import persistence.*;

public interface DebitTransferTransactionCommandReturnVisitor<R> {
    
    public R handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException;
    
}
