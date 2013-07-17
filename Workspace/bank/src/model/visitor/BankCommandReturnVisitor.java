
package model.visitor;

import persistence.*;

public interface BankCommandReturnVisitor<R> {
    
    public R handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException;
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    
}
