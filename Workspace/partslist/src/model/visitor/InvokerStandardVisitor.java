
package model.visitor;

import persistence.*;

public abstract class InvokerStandardVisitor implements InvokerVisitor {
    
    public void handleMateriallist(PersistentMateriallist materiallist) throws PersistenceException{
        this.standardHandling(materiallist);
    }
    public void handlePartsListManager(PersistentPartsListManager partsListManager) throws PersistenceException{
        this.standardHandling(partsListManager);
    }
    public void handleProduct(PersistentProduct product) throws PersistenceException{
        this.standardHandling(product);
    }
    public void handleQPart(PersistentQPart qPart) throws PersistenceException{
        this.standardHandling(qPart);
    }
    public void handleNotCached(PersistentNotCached notCached) throws PersistenceException{
        this.standardHandling(notCached);
    }
    public void handleMaterial(PersistentMaterial material) throws PersistenceException{
        this.standardHandling(material);
    }
    public void handleMateriallistValue(PersistentMateriallistValue materiallistValue) throws PersistenceException{
        this.standardHandling(materiallistValue);
    }
    public void handleCached(PersistentCached cached) throws PersistenceException{
        this.standardHandling(cached);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    protected abstract void standardHandling(Invoker invoker) throws PersistenceException;
}
