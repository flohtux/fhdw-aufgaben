
package view.visitor;
import view.UserException;
import view.*;

public interface LimitStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMinLimitState(MinLimitStateView minLimitState) throws ModelException, E;
    public R handleMaxLimitState(MaxLimitStateView maxLimitState) throws ModelException, E;
    
}
