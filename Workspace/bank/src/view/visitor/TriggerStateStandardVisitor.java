
package view.visitor;

import view.*;

public abstract class TriggerStateStandardVisitor implements TriggerStateVisitor {
    
    public void handleDisabledState(DisabledStateView disabledState) throws ModelException{
        this.standardHandling(disabledState);
    }
    public void handleEnabledState(EnabledStateView enabledState) throws ModelException{
        this.standardHandling(enabledState);
    }
    protected abstract void standardHandling(TriggerStateView triggerState) throws ModelException;
}
