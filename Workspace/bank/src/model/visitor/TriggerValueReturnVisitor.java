
package model.visitor;

import persistence.*;

public interface TriggerValueReturnVisitor<R> {
    
    public R handleNoTrigger(PersistentNoTrigger noTrigger) throws PersistenceException;
    public R handleTrigger(PersistentTrigger trigger) throws PersistenceException;
    
}
