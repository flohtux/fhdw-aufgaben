
package model.visitor;

import persistence.*;

public abstract class LimitTypeStandardVisitor implements LimitTypeVisitor {
    
    public void handleNoLimit(PersistentNoLimit noLimit) throws PersistenceException{
        this.standardHandling(noLimit);
    }
    public void handleLimit(PersistentLimit limit) throws PersistenceException{
        this.standardHandling(limit);
    }
    protected abstract void standardHandling(PersistentLimitType limitType) throws PersistenceException;
}
