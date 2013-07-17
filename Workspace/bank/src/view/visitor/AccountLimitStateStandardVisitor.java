
package view.visitor;

import view.*;

public abstract class AccountLimitStateStandardVisitor implements AccountLimitStateVisitor {
    
    public void handleMinLimitState(MinLimitStateView minLimitState) throws ModelException{
        this.standardHandling(minLimitState);
    }
    public void handleNoLimitState(NoLimitStateView noLimitState) throws ModelException{
        this.standardHandling(noLimitState);
    }
    public void handleMaxLimitState(MaxLimitStateView maxLimitState) throws ModelException{
        this.standardHandling(maxLimitState);
    }
    protected abstract void standardHandling(AccountLimitStateView accountLimitState) throws ModelException;
}
