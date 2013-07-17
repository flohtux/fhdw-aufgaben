
package model.visitor;
import model.UserException;
import persistence.*;

public interface StateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleNotCached(PersistentNotCached notCached) throws PersistenceException, E;
    public R handleCached(PersistentCached cached) throws PersistenceException, E;
    
}
