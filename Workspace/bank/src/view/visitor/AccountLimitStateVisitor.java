
package view.visitor;

import view.*;

public interface AccountLimitStateVisitor extends LimitStateVisitor{
    
    public void handleNoLimitState(NoLimitStateView noLimitState) throws ModelException;
    
}
