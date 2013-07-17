
package model.visitor;

import persistence.*;

public interface InvokerReturnVisitor<R> extends StateReturnVisitor<R> ,ComponentReturnVisitor<R> {
    
    public R handleMateriallist(PersistentMateriallist materiallist) throws PersistenceException;
    public R handlePartsListManager(PersistentPartsListManager partsListManager) throws PersistenceException;
    public R handleQPart(PersistentQPart qPart) throws PersistenceException;
    public R handleMateriallistValue(PersistentMateriallistValue materiallistValue) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    
}
