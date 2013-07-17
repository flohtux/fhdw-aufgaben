
package model.visitor;

import persistence.*;

public abstract class PartsListManagerCommandStandardVisitor implements PartsListManagerCommandVisitor {
    
    public void handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException{
        this.standardHandling(addComponentCommand);
    }
    public void handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException{
        this.standardHandling(createComponentCommand);
    }
    protected abstract void standardHandling(PartsListManagerCommand partsListManagerCommand) throws PersistenceException;
}
