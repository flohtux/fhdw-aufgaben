
package model.visitor;
import model.UserException;
import persistence.*;

public interface CommonDateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException, E;
    public R handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}
