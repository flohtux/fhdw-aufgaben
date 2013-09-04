
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountServiceCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException, E;
    
}
