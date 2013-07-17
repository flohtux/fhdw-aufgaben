
package view.visitor;

import view.*;

public interface LimitStateReturnVisitor<R> {
    
    public R handleMinLimitState(MinLimitStateView minLimitState) throws ModelException;
    public R handleMaxLimitState(MaxLimitStateView maxLimitState) throws ModelException;
    
}
