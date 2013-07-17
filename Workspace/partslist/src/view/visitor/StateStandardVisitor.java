
package view.visitor;

import view.*;

public abstract class StateStandardVisitor implements StateVisitor {
    
    public void handleNotCached(NotCachedView notCached) throws ModelException{
        this.standardHandling(notCached);
    }
    public void handleCached(CachedView cached) throws ModelException{
        this.standardHandling(cached);
    }
    protected abstract void standardHandling(StateView state) throws ModelException;
}
