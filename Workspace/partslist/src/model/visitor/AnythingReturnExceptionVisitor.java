
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends StateReturnExceptionVisitor<R, E> ,CommonDateReturnExceptionVisitor<R, E> ,ComponentReturnExceptionVisitor<R, E> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public R handleCreateComponentCommand(PersistentCreateComponentCommand createComponentCommand) throws PersistenceException, E;
    public R handlePartsListManager(PersistentPartsListManager partsListManager) throws PersistenceException, E;
    public R handleQPart(PersistentQPart qPart) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    public R handleAddComponentCommand(PersistentAddComponentCommand addComponentCommand) throws PersistenceException, E;
    public R handleMateriallist(PersistentMateriallist materiallist) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public R handleMateriallistValue(PersistentMateriallistValue materiallistValue) throws PersistenceException, E;
    
}
