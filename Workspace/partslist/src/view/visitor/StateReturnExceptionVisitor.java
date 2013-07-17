
package view.visitor;
import view.UserException;
import view.*;

public interface StateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleNotCached(NotCachedView notCached) throws ModelException, E;
    public R handleCached(CachedView cached) throws ModelException, E;
    
}
