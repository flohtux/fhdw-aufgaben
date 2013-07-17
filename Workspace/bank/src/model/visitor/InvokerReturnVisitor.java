
package model.visitor;

import persistence.*;

public interface InvokerReturnVisitor<R> extends ServiceReturnVisitor<R> {
    
    public R handleServer(PersistentServer server) throws PersistenceException;
    
}
