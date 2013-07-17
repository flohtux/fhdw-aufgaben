
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends StateVisitor,CommonDateVisitor,ComponentVisitor{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public void handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException;
    public void handlePartsListManager(PersistentPartsListManager partsListManager) throws PersistenceException;
    public void handleQPart(PersistentQPart qPart) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException;
    public void handleMateriallist(PersistentMateriallist materiallist) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public void handleMateriallistValue(PersistentMateriallistValue materiallistValue) throws PersistenceException;
    
}
