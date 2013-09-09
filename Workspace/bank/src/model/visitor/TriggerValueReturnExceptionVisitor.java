
package model.visitor;
import model.UserException;
import persistence.*;

public interface TriggerValueReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleNoTrigger(PersistentNoTrigger noTrigger) throws PersistenceException, E;
    public R handleTrigger(PersistentTrigger trigger) throws PersistenceException, E;
    
}
