
package view.visitor;

import view.*;

public abstract class TriggerValueStandardVisitor implements TriggerValueVisitor {
    
    public void handleNoTrigger(NoTriggerView noTrigger) throws ModelException{
        this.standardHandling(noTrigger);
    }
    public void handleTrigger(TriggerView trigger) throws ModelException{
        this.standardHandling(trigger);
    }
    protected abstract void standardHandling(TriggerValueView triggerValue) throws ModelException;
}
