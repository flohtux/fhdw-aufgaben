
package model.visitor;

import persistence.*;

public interface DebitTransferTransactionCommandVisitor {
    
    public void handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException;
    
}
