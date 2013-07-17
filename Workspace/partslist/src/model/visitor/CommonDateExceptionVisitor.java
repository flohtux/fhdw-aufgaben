
package model.visitor;
import model.UserException;
import persistence.*;

public interface CommonDateExceptionVisitor<E extends UserException> {
    
    public void handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException, E;
    public void handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}
