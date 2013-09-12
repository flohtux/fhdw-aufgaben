
package model.visitor;

import persistence.*;

public abstract class TriggerValueStandardVisitor implements TriggerValueVisitor {
    
    public void handleNoTrigger(PersistentNoTrigger noTrigger) throws PersistenceException{
        this.standardHandling(noTrigger);
    }
    public void handleTrigger(PersistentTrigger trigger) throws PersistenceException{
        this.standardHandling(trigger);
    }
    protected abstract void standardHandling(PersistentTriggerValue triggerValue) throws PersistenceException;
}
