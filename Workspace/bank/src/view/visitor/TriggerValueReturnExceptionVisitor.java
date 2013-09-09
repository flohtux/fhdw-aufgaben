
package view.visitor;
import view.UserException;
import view.*;

public interface TriggerValueReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleNoTrigger(NoTriggerView noTrigger) throws ModelException, E;
    public R handleTrigger(TriggerView trigger) throws ModelException, E;
    
}
