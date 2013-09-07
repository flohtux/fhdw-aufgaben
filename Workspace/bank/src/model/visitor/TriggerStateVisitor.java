
package model.visitor;

import persistence.*;

public interface TriggerStateVisitor {
    
    public void handleDisabledState(PersistentDisabledState disabledState) throws PersistenceException;
    public void handleEnabledState(PersistentEnabledState enabledState) throws PersistenceException;
    
}
