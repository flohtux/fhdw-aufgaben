
package model.visitor;

import persistence.*;

public abstract class BankCommandStandardVisitor implements BankCommandVisitor {
    
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException{
        this.standardHandling(createAccountCommand);
    }
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException{
        this.standardHandling(changeNameCommand);
    }
    protected abstract void standardHandling(BankCommand bankCommand) throws PersistenceException;
}
