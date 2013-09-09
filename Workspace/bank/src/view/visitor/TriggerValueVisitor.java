
package view.visitor;

import view.*;

public interface TriggerValueVisitor {
    
    public void handleNoTrigger(NoTriggerView noTrigger) throws ModelException;
    public void handleTrigger(TriggerView trigger) throws ModelException;
    
}
