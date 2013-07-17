
package model.visitor;

import persistence.*;

public interface PartsListManagerCommandVisitor {
    
    public void handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException;
    public void handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException;
    
}
