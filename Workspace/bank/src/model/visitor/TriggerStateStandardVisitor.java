
package model.visitor;

import persistence.*;

public abstract class TriggerStateStandardVisitor implements TriggerStateVisitor {
    
    public void handleDisabledState(PersistentDisabledState disabledState) throws PersistenceException{
        this.standardHandling(disabledState);
    }
    public void handleEnabledState(PersistentEnabledState enabledState) throws PersistenceException{
        this.standardHandling(enabledState);
    }
    protected abstract void standardHandling(PersistentTriggerState triggerState) throws PersistenceException;
}
