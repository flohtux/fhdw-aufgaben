
package model.visitor;

import persistence.*;

public abstract class CommandStandardVisitor implements CommandVisitor {
    
    public void handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException{
        this.standardHandling(createComponentCommand);
    }
    public void handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException{
        this.standardHandling(addComponentCommand);
    }
    protected abstract void standardHandling(Command command) throws PersistenceException;
}
