
package model.visitor;

import persistence.*;

public abstract class AccountServiceCommandStandardVisitor implements AccountServiceCommandVisitor {
    
    public void handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException{
        this.standardHandling(useTemplateCommand);
    }
    protected abstract void standardHandling(AccountServiceCommand accountServiceCommand) throws PersistenceException;
}
