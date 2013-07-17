
package model.visitor;

import persistence.*;

public interface CommonDateVisitor {
    
    public void handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException;
    public void handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}
