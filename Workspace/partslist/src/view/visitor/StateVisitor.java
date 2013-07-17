
package view.visitor;

import view.*;

public interface StateVisitor {
    
    public void handleNotCached(NotCachedView notCached) throws ModelException;
    public void handleCached(CachedView cached) throws ModelException;
    
}
