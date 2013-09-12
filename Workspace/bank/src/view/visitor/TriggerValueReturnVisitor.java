
package view.visitor;

import view.*;

public interface TriggerValueReturnVisitor<R> {
    
    public R handleNoTrigger(NoTriggerView noTrigger) throws ModelException;
    public R handleTrigger(TriggerView trigger) throws ModelException;
    
}
