
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handlePartsListManager(PersistentPartsListManager partsListManager) throws PersistenceException;
    public abstract void handleProduct(PersistentProduct product) throws PersistenceException;
    public abstract void handleQPart(PersistentQPart qPart) throws PersistenceException;
    public abstract void handleMaterial(PersistentMaterial material) throws PersistenceException;
    public abstract void handleCached(PersistentCached cached) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleMateriallist(PersistentMateriallist materiallist) throws PersistenceException;
    public abstract void handleNotCached(PersistentNotCached notCached) throws PersistenceException;
    public abstract void handleMateriallistValue(PersistentMateriallistValue materiallistValue) throws PersistenceException;
    
}
