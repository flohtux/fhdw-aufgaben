
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountServiceCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException, E;
    public R handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException, E;
    
}
