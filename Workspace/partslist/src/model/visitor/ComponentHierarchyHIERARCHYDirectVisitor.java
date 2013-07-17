
package model.visitor;

import persistence.*;

public abstract class ComponentHierarchyHIERARCHYDirectVisitor implements ComponentHierarchyHIERARCHYVisitor {
    
    public abstract void handleQPart(PersistentQPart qPart) throws PersistenceException;
    
    public abstract void handleComponent(PersistentComponent component) throws PersistenceException;
    
    public void handleProduct(PersistentProduct product) throws PersistenceException{
        this.handleComponent(product);
    }
    public void handleMaterial(PersistentMaterial material) throws PersistenceException{
        this.handleComponent(material);
    }
    
}
