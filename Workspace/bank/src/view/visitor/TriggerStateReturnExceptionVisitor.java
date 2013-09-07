
package view.visitor;
import view.UserException;
import view.*;

public interface TriggerStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleDisabledState(DisabledStateView disabledState) throws ModelException, E;
    public R handleEnabledState(EnabledStateView enabledState) throws ModelException, E;
    
}
