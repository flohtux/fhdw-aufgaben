
package model.visitor;
import model.UserException;
import persistence.*;

public interface InvokerReturnExceptionVisitor<R, E extends UserException> extends ServiceReturnExceptionVisitor<R, E> {
    
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    
}
