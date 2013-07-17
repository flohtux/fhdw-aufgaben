
package model.visitor;
import model.UserException;
import persistence.*;

public interface BankCreatorCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException, E;
    
}
