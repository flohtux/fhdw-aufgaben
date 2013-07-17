
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingExceptionVisitor<E extends UserException> extends StateExceptionVisitor<E>,CommonDateExceptionVisitor<E>,ComponentExceptionVisitor<E>{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public void handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException, E;
    public void handlePartsListManager(PersistentPartsListManager partsListManager) throws PersistenceException, E;
    public void handleQPart(PersistentQPart qPart) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException, E;
    public void handleMateriallist(PersistentMateriallist materiallist) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public void handleMateriallistValue(PersistentMateriallistValue materiallistValue) throws PersistenceException, E;
    
}
