
package model.visitor;
import model.UserException;
import persistence.*;

public interface InvokerReturnExceptionVisitor<R, E extends UserException> extends StateReturnExceptionVisitor<R, E> ,ComponentReturnExceptionVisitor<R, E> {
    
    public R handleMateriallist(PersistentMateriallist materiallist) throws PersistenceException, E;
    public R handlePartsListManager(PersistentPartsListManager partsListManager) throws PersistenceException, E;
    public R handleQPart(PersistentQPart qPart) throws PersistenceException, E;
    public R handleMateriallistValue(PersistentMateriallistValue materiallistValue) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    
}
