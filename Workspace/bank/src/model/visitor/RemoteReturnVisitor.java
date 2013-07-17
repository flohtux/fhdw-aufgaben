
package model.visitor;

import persistence.*;

public interface RemoteReturnVisitor<R> extends ServiceReturnVisitor<R> {
    
    public R handleServer(PersistentServer server) throws PersistenceException;
    
}
