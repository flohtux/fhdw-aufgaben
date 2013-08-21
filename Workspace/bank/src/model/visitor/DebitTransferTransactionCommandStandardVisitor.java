
package model.visitor;

import persistence.*;

public abstract class DebitTransferTransactionCommandStandardVisitor implements DebitTransferTransactionCommandVisitor {
    
    public void handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException{
        this.standardHandling(executeCommand);
    }
    protected abstract void standardHandling(DebitTransferTransactionCommand debitTransferTransactionCommand) throws PersistenceException;
}
