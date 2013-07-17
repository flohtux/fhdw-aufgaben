
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handlePartsListManager(PartsListManagerView partsListManager) throws ModelException{
        this.standardHandling(partsListManager);
    }
    public void handleProduct(ProductView product) throws ModelException{
        this.standardHandling(product);
    }
    public void handleQPart(QPartView qPart) throws ModelException{
        this.standardHandling(qPart);
    }
    public void handleMaterial(MaterialView material) throws ModelException{
        this.standardHandling(material);
    }
    public void handleCached(CachedView cached) throws ModelException{
        this.standardHandling(cached);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleMateriallist(MateriallistView materiallist) throws ModelException{
        this.standardHandling(materiallist);
    }
    public void handleNotCached(NotCachedView notCached) throws ModelException{
        this.standardHandling(notCached);
    }
    public void handleMateriallistValue(MateriallistValueView materiallistValue) throws ModelException{
        this.standardHandling(materiallistValue);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
