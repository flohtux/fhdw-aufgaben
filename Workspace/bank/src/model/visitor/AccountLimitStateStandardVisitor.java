
package model.visitor;

import persistence.*;

public abstract class AccountLimitStateStandardVisitor implements AccountLimitStateVisitor {
    
    public void handleMinLimitState(PersistentMinLimitState minLimitState) throws PersistenceException{
        this.standardHandling(minLimitState);
    }
    public void handleNoLimitState(PersistentNoLimitState noLimitState) throws PersistenceException{
        this.standardHandling(noLimitState);
    }
    public void handleMaxLimitState(PersistentMaxLimitState maxLimitState) throws PersistenceException{
        this.standardHandling(maxLimitState);
    }
    protected abstract void standardHandling(PersistentAccountLimitState accountLimitState) throws PersistenceException;
}
