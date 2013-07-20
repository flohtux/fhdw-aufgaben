
package model.visitor;

import persistence.*;

public interface LimitTypeVisitor {
    
    public void handleNoLimit(PersistentNoLimit noLimit) throws PersistenceException;
    public void handleLimit(PersistentLimit limit) throws PersistenceException;
    
}
