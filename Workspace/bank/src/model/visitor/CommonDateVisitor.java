
package model.visitor;

import persistence.*;

public interface CommonDateVisitor {
    
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException;
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}
