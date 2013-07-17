
package view.visitor;
import view.UserException;
import view.*;

public interface AccountLimitStateReturnExceptionVisitor<R, E extends UserException> extends LimitStateReturnExceptionVisitor<R, E> {
    
    public R handleNoLimitState(NoLimitStateView noLimitState) throws ModelException, E;
    
}
