
package model.visitor;
import model.UserException;
import persistence.*;

public interface RemoteReturnExceptionVisitor<R, E extends UserException> extends ServiceReturnExceptionVisitor<R, E> {
    
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    
}
