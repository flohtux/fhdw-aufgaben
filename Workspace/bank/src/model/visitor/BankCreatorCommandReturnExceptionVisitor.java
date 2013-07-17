
package model.visitor;
import model.UserException;
import persistence.*;

public interface BankCreatorCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException, E;
    
}
