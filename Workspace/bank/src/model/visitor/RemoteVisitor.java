
package model.visitor;

import persistence.*;

public interface RemoteVisitor extends ServiceVisitor{
    
    public void handleServer(PersistentServer server) throws PersistenceException;
    
}
