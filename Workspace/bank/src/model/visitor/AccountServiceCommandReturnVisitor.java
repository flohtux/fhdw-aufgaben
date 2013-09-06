
package model.visitor;

import persistence.*;

public interface AccountServiceCommandReturnVisitor<R> {
    
    public R handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException;
    
}
