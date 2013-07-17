
package model.visitor;
import model.UserException;
import persistence.*;

public interface ComponentReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleProduct(PersistentProduct product) throws PersistenceException, E;
    public R handleMaterial(PersistentMaterial material) throws PersistenceException, E;
    
}
