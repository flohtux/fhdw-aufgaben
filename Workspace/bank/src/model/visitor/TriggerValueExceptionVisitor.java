
package model.visitor;
import model.UserException;
import persistence.*;

public interface TriggerValueExceptionVisitor<E extends UserException> {
    
    public void handleNoTrigger(PersistentNoTrigger noTrigger) throws PersistenceException, E;
    public void handleTrigger(PersistentTrigger trigger) throws PersistenceException, E;
    
}
