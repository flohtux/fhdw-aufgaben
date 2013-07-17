
package view.visitor;
import view.UserException;
import view.*;

public interface AccountLimitStateExceptionVisitor<E extends UserException> extends LimitStateExceptionVisitor<E>{
    
    public void handleNoLimitState(NoLimitStateView noLimitState) throws ModelException, E;
    
}
