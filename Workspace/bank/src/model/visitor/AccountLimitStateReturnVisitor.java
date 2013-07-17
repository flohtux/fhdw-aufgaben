
package model.visitor;

import persistence.*;

public interface AccountLimitStateReturnVisitor<R> extends LimitStateReturnVisitor<R> {
    
    public R handleNoLimitState(PersistentNoLimitState noLimitState) throws PersistenceException;
    
}
