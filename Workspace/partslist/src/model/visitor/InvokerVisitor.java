
package model.visitor;

import persistence.*;

public interface InvokerVisitor extends StateVisitor,ComponentVisitor{
    
    public void handleMateriallist(PersistentMateriallist materiallist) throws PersistenceException;
    public void handlePartsListManager(PersistentPartsListManager partsListManager) throws PersistenceException;
    public void handleQPart(PersistentQPart qPart) throws PersistenceException;
    public void handleMateriallistValue(PersistentMateriallistValue materiallistValue) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    
}
