
package model.visitor;

import persistence.*;

public interface TriggerValueVisitor {
    
    public void handleNoTrigger(PersistentNoTrigger noTrigger) throws PersistenceException;
    public void handleTrigger(PersistentTrigger trigger) throws PersistenceException;
    
}
