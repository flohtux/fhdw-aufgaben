
package model.visitor;

import persistence.*;

public interface TriggerStateReturnVisitor<R> {
    
    public R handleDisabledState(PersistentDisabledState disabledState) throws PersistenceException;
    public R handleEnabledState(PersistentEnabledState enabledState) throws PersistenceException;
    
}
