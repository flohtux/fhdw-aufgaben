
package view.visitor;

import view.*;

public interface RemoteReturnVisitor<R> extends ServiceReturnVisitor<R> {
    
    public R handleServer(ServerView server) throws ModelException;
    
}
