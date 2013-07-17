
package model.visitor;
import model.UserException;
import persistence.*;

public interface ComponentExceptionVisitor<E extends UserException> {
    
    public void handleProduct(PersistentProduct product) throws PersistenceException, E;
    public void handleMaterial(PersistentMaterial material) throws PersistenceException, E;
    
}
