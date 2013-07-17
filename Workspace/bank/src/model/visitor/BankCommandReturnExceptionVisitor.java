
package model.visitor;
import model.UserException;
import persistence.*;

public interface BankCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException, E;
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    
}
