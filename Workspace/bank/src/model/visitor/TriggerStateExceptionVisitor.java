
package model.visitor;
import model.UserException;
import persistence.*;

public interface TriggerStateExceptionVisitor<E extends UserException> {
    
    public void handleDisabledState(PersistentDisabledState disabledState) throws PersistenceException, E;
    public void handleEnabledState(PersistentEnabledState enabledState) throws PersistenceException, E;
    
}
