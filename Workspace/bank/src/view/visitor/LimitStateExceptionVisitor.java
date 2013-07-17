
package view.visitor;
import view.UserException;
import view.*;

public interface LimitStateExceptionVisitor<E extends UserException> {
    
    public void handleMinLimitState(MinLimitStateView minLimitState) throws ModelException, E;
    public void handleMaxLimitState(MaxLimitStateView maxLimitState) throws ModelException, E;
    
}
