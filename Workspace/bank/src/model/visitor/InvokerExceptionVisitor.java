
package model.visitor;
import model.UserException;
import persistence.*;

public interface InvokerExceptionVisitor<E extends UserException> extends ServiceExceptionVisitor<E>{
    
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    
}
