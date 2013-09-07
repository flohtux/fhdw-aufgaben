
package view.visitor;
import view.UserException;
import view.*;

public interface TriggerStateExceptionVisitor<E extends UserException> {
    
    public void handleDisabledState(DisabledStateView disabledState) throws ModelException, E;
    public void handleEnabledState(EnabledStateView enabledState) throws ModelException, E;
    
}
