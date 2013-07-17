
package model.visitor;
import model.UserException;
import persistence.*;

public interface BankCommandExceptionVisitor<E extends UserException> {
    
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException, E;
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    
}
