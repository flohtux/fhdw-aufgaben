
package model.visitor;

import persistence.*;

public abstract class ComponentHierarchyHIERARCHYStandardVisitor implements ComponentHierarchyHIERARCHYVisitor {
    
    public void handleProduct(PersistentProduct product) throws PersistenceException{
        this.standardHandling(product);
    }
    public void handleQPart(PersistentQPart qPart) throws PersistenceException{
        this.standardHandling(qPart);
    }
    public void handleMaterial(PersistentMaterial material) throws PersistenceException{
        this.standardHandling(material);
    }
    protected abstract void standardHandling(ComponentHierarchyHIERARCHY componentHierarchyHIERARCHY) throws PersistenceException;
}
