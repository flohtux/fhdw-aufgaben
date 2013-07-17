
package model.visitor;

import persistence.*;

public interface BankCreatorCommandReturnVisitor<R> {
    
    public R handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException;
    
}
