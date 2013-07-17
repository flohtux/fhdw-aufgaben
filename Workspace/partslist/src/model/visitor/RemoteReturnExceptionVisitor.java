
package model.visitor;
import model.UserException;
import persistence.*;

public interface RemoteReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    
}
