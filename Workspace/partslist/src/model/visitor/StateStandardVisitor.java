
package model.visitor;

import persistence.*;

public abstract class StateStandardVisitor implements StateVisitor {
    
    public void handleNotCached(PersistentNotCached notCached) throws PersistenceException{
        this.standardHandling(notCached);
    }
    public void handleCached(PersistentCached cached) throws PersistenceException{
        this.standardHandling(cached);
    }
    protected abstract void standardHandling(PersistentState state) throws PersistenceException;
}
