
package model.visitor;
import model.UserException;
import persistence.*;

public interface PartsListManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException, E;
    public void handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException, E;
    
}
