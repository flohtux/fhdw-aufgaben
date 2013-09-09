
package view.visitor;
import view.UserException;
import view.*;

public interface TriggerValueExceptionVisitor<E extends UserException> {
    
    public void handleNoTrigger(NoTriggerView noTrigger) throws ModelException, E;
    public void handleTrigger(TriggerView trigger) throws ModelException, E;
    
}
