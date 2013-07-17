
package model.visitor;
import model.UserException;
import persistence.*;

public interface StateExceptionVisitor<E extends UserException> {
    
    public void handleNotCached(PersistentNotCached notCached) throws PersistenceException, E;
    public void handleCached(PersistentCached cached) throws PersistenceException, E;
    
}
