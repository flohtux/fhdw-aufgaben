
package model.visitor;
import model.UserException;
import persistence.*;

public interface LimitTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleNoLimit(PersistentNoLimit noLimit) throws PersistenceException, E;
    public R handleLimit(PersistentLimit limit) throws PersistenceException, E;
    
}
