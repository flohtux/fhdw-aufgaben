
package model.visitor;

import persistence.*;

public interface CommonDateReturnVisitor<R> {
    
    public R handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException;
    public R handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}
