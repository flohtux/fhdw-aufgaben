
package view.visitor;

import view.*;

public interface AccountLimitStateReturnVisitor<R> extends LimitStateReturnVisitor<R> {
    
    public R handleNoLimitState(NoLimitStateView noLimitState) throws ModelException;
    
}
