
package model.visitor;

import persistence.*;

public interface ComponentReturnVisitor<R> {
    
    public R handleProduct(PersistentProduct product) throws PersistenceException;
    public R handleMaterial(PersistentMaterial material) throws PersistenceException;
    
}
