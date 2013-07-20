
package model.visitor;
import model.UserException;
import persistence.*;

public interface LimitTypeExceptionVisitor<E extends UserException> {
    
    public void handleNoLimit(PersistentNoLimit noLimit) throws PersistenceException, E;
    public void handleLimit(PersistentLimit limit) throws PersistenceException, E;
    
}
