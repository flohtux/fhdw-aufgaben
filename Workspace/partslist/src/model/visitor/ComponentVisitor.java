
package model.visitor;

import persistence.*;

public interface ComponentVisitor {
    
    public void handleProduct(PersistentProduct product) throws PersistenceException;
    public void handleMaterial(PersistentMaterial material) throws PersistenceException;
    
}
