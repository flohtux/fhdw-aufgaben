
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException{
        this.standardHandling(createComponentCommand);
    }
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
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
    public void handleMaterial(PersistentMaterial material) throws PersistenceException{
        this.standardHandling(material);
    }
    public void handleCached(PersistentCached cached) throws PersistenceException{
        this.standardHandling(cached);
    }
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException{
        this.standardHandling(addComponentCommand);
    }
    public void handleMateriallist(PersistentMateriallist materiallist) throws PersistenceException{
        this.standardHandling(materiallist);
    }
    public void handleNotCached(PersistentNotCached notCached) throws PersistenceException{
        this.standardHandling(notCached);
    }
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleMateriallistValue(PersistentMateriallistValue materiallistValue) throws PersistenceException{
        this.standardHandling(materiallistValue);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
