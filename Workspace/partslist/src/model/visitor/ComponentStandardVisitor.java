
package model.visitor;

import persistence.*;

public abstract class ComponentStandardVisitor implements ComponentVisitor {
    
    public void handleProduct(PersistentProduct product) throws PersistenceException{
        this.standardHandling(product);
    }
    public void handleMaterial(PersistentMaterial material) throws PersistenceException{
        this.standardHandling(material);
    }
    protected abstract void standardHandling(PersistentComponent component) throws PersistenceException;
}
