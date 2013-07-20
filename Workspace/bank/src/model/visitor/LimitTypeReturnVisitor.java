
package model.visitor;

import persistence.*;

public interface LimitTypeReturnVisitor<R> {
    
    public R handleNoLimit(PersistentNoLimit noLimit) throws PersistenceException;
    public R handleLimit(PersistentLimit limit) throws PersistenceException;
    
}
