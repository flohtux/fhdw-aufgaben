
package model.visitor;

import persistence.*;

public interface AccountLimitStateVisitor extends LimitStateVisitor{
    
    public void handleNoLimitState(PersistentNoLimitState noLimitState) throws PersistenceException;
    
}
