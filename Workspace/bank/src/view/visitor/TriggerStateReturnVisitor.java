
package view.visitor;

import view.*;

public interface TriggerStateReturnVisitor<R> {
    
    public R handleDisabledState(DisabledStateView disabledState) throws ModelException;
    public R handleEnabledState(EnabledStateView enabledState) throws ModelException;
    
}
