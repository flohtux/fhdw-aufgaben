
package model.visitor;
import model.UserException;
import persistence.*;

public interface InvokerExceptionVisitor<E extends UserException> extends StateExceptionVisitor<E>,ComponentExceptionVisitor<E>{
    
    public void handleMateriallist(PersistentMateriallist materiallist) throws PersistenceException, E;
    public void handlePartsListManager(PersistentPartsListManager partsListManager) throws PersistenceException, E;
    public void handleQPart(PersistentQPart qPart) throws PersistenceException, E;
    public void handleMateriallistValue(PersistentMateriallistValue materiallistValue) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    
}
