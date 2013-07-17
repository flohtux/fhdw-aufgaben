
package view.visitor;

import view.*;

public abstract class AccountLimitStateDirectVisitor implements AccountLimitStateVisitor {
    
    public abstract void handleNoLimitState(NoLimitStateView noLimitState) throws ModelException;
    
    public abstract void handleLimitState(LimitStateView limitState) throws ModelException;
    
    public void handleMinLimitState(MinLimitStateView minLimitState) throws ModelException{
        this.handleLimitState(minLimitState);
    }
    public void handleMaxLimitState(MaxLimitStateView maxLimitState) throws ModelException{
        this.handleLimitState(maxLimitState);
    }
    
}
