
package model.visitor;
import model.UserException;
import persistence.*;

public interface TriggerStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleDisabledState(PersistentDisabledState disabledState) throws PersistenceException, E;
    public R handleEnabledState(PersistentEnabledState enabledState) throws PersistenceException, E;
    
}
