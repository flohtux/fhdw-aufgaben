
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountServiceCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException, E;
    public void handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException, E;
    
}
