
package view.visitor;
import view.UserException;
import view.*;

public interface StateExceptionVisitor<E extends UserException> {
    
    public void handleNotCached(NotCachedView notCached) throws ModelException, E;
    public void handleCached(CachedView cached) throws ModelException, E;
    
}
