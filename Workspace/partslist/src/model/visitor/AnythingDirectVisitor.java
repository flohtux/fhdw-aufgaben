
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleMateriallist(PersistentMateriallist materiallist) throws PersistenceException;
    
    public abstract void handlePartsListManager(PersistentPartsListManager partsListManager) throws PersistenceException;
    
    public abstract void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    
    public abstract void handleState(PersistentState state) throws PersistenceException;
    
    public void handleNotCached(PersistentNotCached notCached) throws PersistenceException{
        this.handleState(notCached);
    }
    public void handleCached(PersistentCached cached) throws PersistenceException{
        this.handleState(cached);
    }
    public abstract void handleQPart(PersistentQPart qPart) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    
    public abstract void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
    public void handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException{
        this.handleCommonDate(addComponentCommand);
    }
    public void handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException{
        this.handleCommonDate(createComponentCommand);
    }
    public abstract void handleMateriallistValue(PersistentMateriallistValue materiallistValue) throws PersistenceException;
    
    public abstract void handleComponent(PersistentComponent component) throws PersistenceException;
    
    public void handleProduct(PersistentProduct product) throws PersistenceException{
        this.handleComponent(product);
    }
    public void handleMaterial(PersistentMaterial material) throws PersistenceException{
        this.handleComponent(material);
    }
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    
}
