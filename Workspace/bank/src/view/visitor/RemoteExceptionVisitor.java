
package view.visitor;
import view.UserException;
import view.*;

public interface RemoteExceptionVisitor<E extends UserException> extends ServiceExceptionVisitor<E>{
    
    public void handleServer(ServerView server) throws ModelException, E;
    
}
