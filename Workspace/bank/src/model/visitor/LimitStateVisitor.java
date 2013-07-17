
package model.visitor;

import persistence.*;

public interface LimitStateVisitor {
    
    public void handleMinLimitState(PersistentMinLimitState minLimitState) throws PersistenceException;
    public void handleMaxLimitState(PersistentMaxLimitState maxLimitState) throws PersistenceException;
    
}
