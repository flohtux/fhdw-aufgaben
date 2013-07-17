
package model.visitor;

import persistence.*;

public abstract class AccountLimitStateDirectVisitor implements AccountLimitStateVisitor {
    
    public abstract void handleNoLimitState(PersistentNoLimitState noLimitState) throws PersistenceException;
    
    public abstract void handleLimitState(PersistentLimitState limitState) throws PersistenceException;
    
    public void handleMinLimitState(PersistentMinLimitState minLimitState) throws PersistenceException{
        this.handleLimitState(minLimitState);
    }
    public void handleMaxLimitState(PersistentMaxLimitState maxLimitState) throws PersistenceException{
        this.handleLimitState(maxLimitState);
    }
    
}
