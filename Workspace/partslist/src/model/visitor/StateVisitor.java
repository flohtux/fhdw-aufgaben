
package model.visitor;

import persistence.*;

public interface StateVisitor {
    
    public void handleNotCached(PersistentNotCached notCached) throws PersistenceException;
    public void handleCached(PersistentCached cached) throws PersistenceException;
    
}
