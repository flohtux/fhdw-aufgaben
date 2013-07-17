
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends StateReturnVisitor<R> ,CommonDateReturnVisitor<R> ,ComponentReturnVisitor<R> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public R handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException;
    public R handlePartsListManager(PersistentPartsListManager partsListManager) throws PersistenceException;
    public R handleQPart(PersistentQPart qPart) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException;
    public R handleMateriallist(PersistentMateriallist materiallist) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public R handleMateriallistValue(PersistentMateriallistValue materiallistValue) throws PersistenceException;
    
}
