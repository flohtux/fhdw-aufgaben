
package view.visitor;

import view.*;

public interface LimitStateVisitor {
    
    public void handleMinLimitState(MinLimitStateView minLimitState) throws ModelException;
    public void handleMaxLimitState(MaxLimitStateView maxLimitState) throws ModelException;
    
}
