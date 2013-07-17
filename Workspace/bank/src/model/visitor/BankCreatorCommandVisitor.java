
package model.visitor;

import persistence.*;

public interface BankCreatorCommandVisitor {
    
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException;
    
}
