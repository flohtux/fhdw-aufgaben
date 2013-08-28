
package model.visitor;

import persistence.*;

public interface AccountServiceCommandVisitor {
    
    public void handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException;
    
}
