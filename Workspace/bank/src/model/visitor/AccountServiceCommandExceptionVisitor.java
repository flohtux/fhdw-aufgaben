
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountServiceCommandExceptionVisitor<E extends UserException> {
    
    public void handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException, E;
    
}
