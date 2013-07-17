
package model.visitor;

import persistence.*;

public interface PartsListManagerCommandReturnVisitor<R> {
    
    public R handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException;
    public R handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException;
    
}
