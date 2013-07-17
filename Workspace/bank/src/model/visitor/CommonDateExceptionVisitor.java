
package model.visitor;
import model.UserException;
import persistence.*;

public interface CommonDateExceptionVisitor<E extends UserException> {
    
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException, E;
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}
