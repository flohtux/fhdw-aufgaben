
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleMateriallist(MateriallistView materiallist) throws ModelException;
    
    public abstract void handlePartsListManager(PartsListManagerView partsListManager) throws ModelException;
    
    public abstract void handleState(StateView state) throws ModelException;
    
    public void handleNotCached(NotCachedView notCached) throws ModelException{
        this.handleState(notCached);
    }
    public void handleCached(CachedView cached) throws ModelException{
        this.handleState(cached);
    }
    public abstract void handleQPart(QPartView qPart) throws ModelException;
    
    public abstract void handleMateriallistValue(MateriallistValueView materiallistValue) throws ModelException;
    
    public abstract void handleComponent(ComponentView component) throws ModelException;
    
    public void handleProduct(ProductView product) throws ModelException{
        this.handleComponent(product);
    }
    public void handleMaterial(MaterialView material) throws ModelException{
        this.handleComponent(material);
    }
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    
}
