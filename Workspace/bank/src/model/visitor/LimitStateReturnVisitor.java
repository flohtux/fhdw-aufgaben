
package model.visitor;

import persistence.*;

public interface LimitStateReturnVisitor<R> {
    
    public R handleMinLimitState(PersistentMinLimitState minLimitState) throws PersistenceException;
    public R handleMaxLimitState(PersistentMaxLimitState maxLimitState) throws PersistenceException;
    
}
