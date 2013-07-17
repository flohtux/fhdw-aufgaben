
package model.visitor;

import persistence.*;

public interface BankCommandVisitor {
    
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException;
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    
}
