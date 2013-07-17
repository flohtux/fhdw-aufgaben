
package model.visitor;

import persistence.*;

public interface StateReturnVisitor<R> {
    
    public R handleNotCached(PersistentNotCached notCached) throws PersistenceException;
    public R handleCached(PersistentCached cached) throws PersistenceException;
    
}
