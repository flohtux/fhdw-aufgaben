
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException{
        this.standardHandling(addComponentCommand);
    }
    public void handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException{
        this.standardHandling(createComponentCommand);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    protected abstract void standardHandling(PersistentCommonDate commonDate) throws PersistenceException;
}
