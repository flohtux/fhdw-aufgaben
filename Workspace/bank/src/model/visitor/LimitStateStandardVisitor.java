
package model.visitor;

import persistence.*;

public abstract class LimitStateStandardVisitor implements LimitStateVisitor {
    
    public void handleMinLimitState(PersistentMinLimitState minLimitState) throws PersistenceException{
        this.standardHandling(minLimitState);
    }
    public void handleMaxLimitState(PersistentMaxLimitState maxLimitState) throws PersistenceException{
        this.standardHandling(maxLimitState);
    }
    protected abstract void standardHandling(PersistentLimitState limitState) throws PersistenceException;
}
