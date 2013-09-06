
package view.visitor;

import view.*;

public interface TriggerStateVisitor {
    
    public void handleDisabledState(DisabledStateView disabledState) throws ModelException;
    public void handleEnabledState(EnabledStateView enabledState) throws ModelException;
    
}
