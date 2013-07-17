
package model.visitor;

import persistence.*;

public interface InvokerVisitor extends ServiceVisitor{
    
    public void handleServer(PersistentServer server) throws PersistenceException;
    
}
