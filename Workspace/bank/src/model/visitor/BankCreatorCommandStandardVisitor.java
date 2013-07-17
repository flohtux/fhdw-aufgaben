
package model.visitor;

import persistence.*;

public abstract class BankCreatorCommandStandardVisitor implements BankCreatorCommandVisitor {
    
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException{
        this.standardHandling(createBankCommand);
    }
    protected abstract void standardHandling(BankCreatorCommand bankCreatorCommand) throws PersistenceException;
}
