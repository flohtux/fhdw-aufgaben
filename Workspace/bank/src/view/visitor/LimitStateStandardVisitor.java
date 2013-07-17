
package view.visitor;

import view.*;

public abstract class LimitStateStandardVisitor implements LimitStateVisitor {
    
    public void handleMinLimitState(MinLimitStateView minLimitState) throws ModelException{
        this.standardHandling(minLimitState);
    }
    public void handleMaxLimitState(MaxLimitStateView maxLimitState) throws ModelException{
        this.standardHandling(maxLimitState);
    }
    protected abstract void standardHandling(LimitStateView limitState) throws ModelException;
}
