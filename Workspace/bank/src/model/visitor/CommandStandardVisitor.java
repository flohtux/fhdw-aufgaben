
package model.visitor;

import persistence.*;

public abstract class CommandStandardVisitor implements CommandVisitor {
    
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException{
        this.standardHandling(createAccountCommand);
    }
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException{
        this.standardHandling(createBankCommand);
    }
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException{
        this.standardHandling(changeNameCommand);
    }
    protected abstract void standardHandling(Command command) throws PersistenceException;
}
