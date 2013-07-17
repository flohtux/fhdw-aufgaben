
package view.visitor;

import view.*;

public interface StateReturnVisitor<R> {
    
    public R handleNotCached(NotCachedView notCached) throws ModelException;
    public R handleCached(CachedView cached) throws ModelException;
    
}
